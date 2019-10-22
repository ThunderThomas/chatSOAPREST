package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import models.Message;

public class MessageDao {
	private static Connection connection;
	private static PreparedStatement statement;

	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/login");
		return ds.getConnection();
	}

	public static boolean addMessage(String mittente, String destinatario, String messaggio)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO messaggi (mittente, destinatario, testo) values (?, ?, ?)";
		boolean result;
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		try {
			statement.setString(1, mittente);
			statement.setString(2, destinatario);
			statement.setString(3, messaggio);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}
	
	public static boolean addMessage(String mittente, String destinatario, String messaggio, int id)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO messaggi(mittente, destinatario, testo, risposta) values (?, ?, ?, ?)";
		boolean result;
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		try {
			statement.setString(1, mittente);
			statement.setString(2, destinatario);
			statement.setString(3, messaggio);
			statement.setInt(4, id);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

	public static List<Message> getMessages(String user, String friend) throws ClassNotFoundException, SQLException, NamingException {
		List<Message> list = new ArrayList<Message>();
		String sql = "SELECT * FROM messaggi WHERE mittente = ? AND destinatario = ? "
				+ "OR mittente = ? AND destinatario = ? ORDER BY data";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		try {
			statement.setString(1, user);
			statement.setString(2, friend);
			statement.setString(3, friend);
			statement.setString(4, user);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Message messaggio = new Message();
				messaggio.setId(results.getInt("id"));
				messaggio.setMittente(results.getString("mittente"));
				messaggio.setDestinatario(results.getString("destinatario"));
				messaggio.setTesto(results.getString("testo"));
				messaggio.setData(results.getTimestamp("data"));
				list.add(messaggio);
			}
		} finally {
			statement.close();
			connection.close();
		}
		return list;
	}

	public static boolean editMessage(int id, String testo)
			throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE messaggi SET testo = ? WHERE id = ?";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		boolean result = false;
		try {
			statement.setString(1, testo);
			statement.setInt(2, id);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

	public static boolean deleteMessage(int id) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "DELETE FROM messaggi where id = ?";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		boolean result = false;
		try {
			statement.setInt(1, id);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

}
