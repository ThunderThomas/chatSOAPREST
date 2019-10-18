package bl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import dao.UserDao;
import models.User;

public class UserBusinessLogic {
	
	public static User getUser(String nome) throws ClassNotFoundException, SQLException, NamingException {
		return UserDao.getUser(nome);
	}
	
	public static List<User> getAll() throws ClassNotFoundException, SQLException, NamingException{
		return UserDao.getAll();
	}
	
	public static boolean addUser(String nome, String password, boolean admin) throws ClassNotFoundException, SQLException, NamingException {
		return UserDao.addUser(nome, password, admin);
	}
	
	public static boolean editUser(String nome, String password, boolean admin) throws ClassNotFoundException, SQLException, NamingException {
		return UserDao.editUser(nome, password, admin);
	}
	
	public static boolean deleteUser(String nome) throws ClassNotFoundException, SQLException, NamingException {
		return UserDao.deleteUser(nome);
	}
}
