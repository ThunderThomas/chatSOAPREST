package bl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.MessageDao;
import models.Message;

public class MessageBusinessLogic {

	public static boolean addMessage(String mittente, String destinatario, String messaggio)
			throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.addMessage(mittente, destinatario, messaggio);
	}
	
	public static boolean addMessage(String mittente, String destinatario, String messaggio, int id)
			throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.addMessage(mittente, destinatario, messaggio, id);
	}
	
	public static Message getMessage(int id) throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.getMessage(id);
	}

	public static List<Message> getMessages(String user, String friend) throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.getMessages(user, friend);
	}

	public static boolean editMessage(int id, String testo) throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.editMessage(id, testo);
	}
	
	public static boolean deleteMessage(int id) throws ClassNotFoundException, SQLException, NamingException {
		return MessageDao.deleteMessage(id);
	}

}
