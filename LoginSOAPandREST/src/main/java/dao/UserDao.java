package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import models.User;

public class UserDao {
	private static Connection connection;
	private static PreparedStatement statement;

	public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/login");
		return ds.getConnection();
	}

	public static boolean addUser(String nome, String password, boolean admin)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = "INSERT INTO users values (?, ?, ?)";
		boolean result;
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		try {
			statement.setString(1, nome);
			statement.setString(2, password);
			statement.setBoolean(3, admin);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

	public static User getUser(String nome) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "SELECT * FROM users WHERE username = ?";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		User user = null;
		try {
			statement.setString(1, nome);
			ResultSet results = statement.executeQuery();
			user = new User();
			results.next();
			user.setNome(results.getString("username"));
			user.setPassword(results.getString("password"));
			if (results.getInt("admin") == 1)
				user.setAdmin(true);
			else
				user.setAdmin(false);
		} finally {
			statement.close();
			connection.close();
		}
		return user;
	}

	public static boolean editUser(String nome, String password, boolean admin)
			throws SQLException, ClassNotFoundException, NamingException {
		String sql = "UPDATE users SET password = ?, admin = ? WHERE username = ?";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		boolean result = false;
		try {
			statement.setString(1, password);
			statement.setBoolean(2, admin);
			statement.setString(3, nome);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

	public static boolean deleteUser(String nome) throws SQLException, ClassNotFoundException, NamingException {
		String sql = "DELETE FROM users where username = ?";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		boolean result = false;
		try {
			statement.setString(1, nome);
			result = statement.executeUpdate() != 0;
		} finally {
			statement.close();
			connection.close();
		}
		return result;
	}

	public static List<User> getAll() throws ClassNotFoundException, SQLException, NamingException {
		List<User> list = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		try {
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				User user = new User();
				user.setNome(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setAdmin(results.getInt("admin") == 1);
				list.add(user);
			}
		} finally {
			statement.close();
			connection.close();
		}
		return list;

	}
}