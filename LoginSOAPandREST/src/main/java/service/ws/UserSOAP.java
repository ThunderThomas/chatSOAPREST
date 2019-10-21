package service.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import exceptions.ApplicationException;
import models.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface UserSOAP {
	
	@WebMethod(operationName="aggiungiUtente")
	public boolean addUser(String nome, String password, boolean admin) throws ApplicationException;
	
	@WebMethod(operationName="visualizzaUtente")
	public User getUser(String nome) throws ApplicationException;
	
	@WebMethod(operationName="modificaUtente")
	public boolean editUser(String nome, String password, boolean admin) throws ApplicationException;
	
	@WebMethod(operationName="eliminaUtente")
	public boolean deleteUser(String nome) throws ApplicationException;
	
	@WebMethod(operationName="visualizzaListaUtenti")
	public List<User> getAll() throws ApplicationException;

}
