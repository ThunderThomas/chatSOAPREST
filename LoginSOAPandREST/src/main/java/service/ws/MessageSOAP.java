package service.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import exceptions.ApplicationException;
import models.Message;

@WebService
@SOAPBinding
public interface MessageSOAP {
	
	@WebMethod(operationName="aggiungiMessaggio")
	public boolean addMessage(String mittente, String destinatario, String messaggio)
			throws ApplicationException;
	
	@WebMethod(operationName="visualizzaMessaggi")
	public List<Message> getMessages(String user, String friend) throws ApplicationException;
	
	@WebMethod(operationName="modificaMessaggio")
	public boolean editMessage(int id, String testo) throws ApplicationException;
	
	@WebMethod(operationName="eliminaMessaggio")
	public boolean deleteMessage(int id) throws ApplicationException;
}
