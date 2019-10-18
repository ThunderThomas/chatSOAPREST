package clients;

import java.util.List;

import service.ws.ApplicationException_Exception;
import service.ws.User;
import service.ws.UserSOAPImpl;
import service.ws.UserSOAPImplService;

public class UsersSoapClient {

	public static boolean addUser(String nome, String password, boolean admin) throws ApplicationException_Exception {
		return getClient().addUser(nome, password, admin);
	}

	public static User getUser(String nome) throws ApplicationException_Exception {
		return getClient().getUser(nome);
	}

	public static boolean editUser(String nome, String password, boolean admin) throws ApplicationException_Exception {
		return getClient().editUser(nome, password, admin);
	}

	public static boolean deleteUser(String nome) throws ApplicationException_Exception {
		return getClient().deleteUser(nome);
	}

	public static List<User> getAll() throws ApplicationException_Exception {
		return getClient().getAll();
	}

	public static boolean login(String username, String password) throws ApplicationException_Exception {
		User user = getClient().getUser(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else
			return false;
	}

	private static UserSOAPImpl getClient() {
		UserSOAPImplService service = new UserSOAPImplService();
		UserSOAPImpl client = service.getUserSOAPImplPort();
		return client;
	}
}
