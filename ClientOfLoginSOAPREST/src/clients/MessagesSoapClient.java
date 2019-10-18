package clients;

import java.util.List;

import service.ws.Message;
import service.ws.ApplicationException_Exception;
import service.ws.MessageSOAPImpl;
import service.ws.MessageSOAPImplService;

public class MessagesSoapClient {

	private static MessageSOAPImpl getClient() {
		MessageSOAPImplService service = new MessageSOAPImplService();
		MessageSOAPImpl client = service.getMessageSOAPImplPort();
		return client;
	}

	public static boolean addMessage(String mittente, String destinatario, String messaggio, int id)
			throws ApplicationException_Exception {
		return getClient().addMessage(mittente, destinatario, messaggio);
	}

	public static List<Message> getMessages(String user) throws ApplicationException_Exception {
		return getClient().getMessages(user);
	}

	public static boolean editMessage(int id, String testo) throws ApplicationException_Exception {
		return getClient().editMessage(id, testo);
	}

	public static boolean deleteMessage(int id) throws ApplicationException_Exception {
		return getClient().deleteMessage(id);
	}
}
