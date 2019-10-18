package service.ws;

import java.util.List;

import javax.jws.WebService;

import bl.MessageBusinessLogic;
import exceptions.ApplicationException;
import models.Message;

@WebService
public class MessageSOAPImpl implements MessageSOAP {

	public boolean addMessage(String mittente, String destinatario, String messaggio)
			throws ApplicationException {
		try {
			return MessageBusinessLogic.addMessage(mittente, destinatario, messaggio);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public List<Message> getMessages(String user, String friend) throws ApplicationException {
		try {
			return MessageBusinessLogic.getMessages(user, friend);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public boolean editMessage(int id, String testo) throws ApplicationException {
		try {
			return MessageBusinessLogic.editMessage(id, testo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

	public boolean deleteMessage(int id) throws ApplicationException {
		try {
			return MessageBusinessLogic.deleteMessage(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ApplicationException(e.getMessage(), e);
		}
	}

}
