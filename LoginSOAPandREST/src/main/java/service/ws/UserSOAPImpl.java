package service.ws;

import java.util.List;

import javax.jws.WebService;

import bl.UserBusinessLogic;
import exceptions.ApplicationException;
import models.User;

@WebService
public class UserSOAPImpl implements UserSOAP {

	public boolean addUser(String nome, String password, boolean admin) throws ApplicationException {
		try {
			return UserBusinessLogic.addUser(nome, password, admin);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public User getUser(String nome) throws ApplicationException {
		try {
			return UserBusinessLogic.getUser(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public boolean editUser(String nome, String password, boolean admin) throws ApplicationException {
		try {
			return UserBusinessLogic.editUser(nome, password, admin);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public boolean deleteUser(String nome) throws ApplicationException {
		try {
			return UserBusinessLogic.deleteUser(nome);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public List<User> getAll() throws ApplicationException {
		try {
			return UserBusinessLogic.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

}
