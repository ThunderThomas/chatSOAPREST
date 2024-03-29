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

	public static boolean addMessage(String mittente, String destinatario, String messaggio)
			throws ApplicationException_Exception {
		return getClient().addMessage(mittente, destinatario, messaggio);
	}

	public static boolean replyMessage(String mittente, String destinatario, String messaggio, int id)
			throws ApplicationException_Exception {
		return getClient().replyMessage(mittente, destinatario, messaggio, id);
	}
	
	public static Message getMessage(int id) throws ApplicationException_Exception {
		return getClient().getMessage(id);
	}

	public static List<Message> getMessages(String user, String friend) throws ApplicationException_Exception {
		return getClient().getMessages(user, friend);
	}

	public static boolean editMessage(int id, String testo) throws ApplicationException_Exception {
		return getClient().editMessage(id, testo);
	}

	public static boolean deleteMessage(int id) throws ApplicationException_Exception {
		return getClient().deleteMessage(id);
	}
}
