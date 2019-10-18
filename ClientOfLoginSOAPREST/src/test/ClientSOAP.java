package test;

import java.util.*;

import service.ws.ApplicationException_Exception;
import service.ws.User;
import service.ws.UserSOAPImpl;
import service.ws.UserSOAPImplService;

public class ClientSOAP {

	public static void main(String[] args) throws ApplicationException_Exception {
		
		UserSOAPImplService service = new UserSOAPImplService();
		
		UserSOAPImpl client = service.getUserSOAPImplPort();
		
		client.addUser("Giorgio", "Vanni", true);
		client.addUser("MarcoFarina", "NES", false);
		
		User persona = client.getUser("MarcoFarina");
		
		System.out.print(persona.getNome() + " " + persona.getPassword());
		if (persona.isAdmin()) System.out.println(" Admin");
		else System.out.println(" not an Admin");
		
		System.out.println();
		
		client.editUser("MarcoFarina", "PSP", true);
		
		persona = client.getUser("MarcoFarina");
		
		System.out.print(persona.getNome() + " " + persona.getPassword());
		if (persona.isAdmin()) System.out.println(" Admin");
		else System.out.println(" not an Admin");
		
		System.out.println();
		
		List<User> lista = client.getAll();
		
		for (User u : lista) {
			System.out.print(u.getNome() + " " + u.getPassword());
			if (u.isAdmin()) System.out.println(" Admin");
			else System.out.println(" not an Admin");
		}
		
		System.out.println();
		
		client.deleteUser("Giorgio");
		
		lista = client.getAll();
		
		for (User u : lista) {
			System.out.print(u.getNome() + " " + u.getPassword());
			if (u.isAdmin()) System.out.println(" Admin");
			else System.out.println(" not an Admin");
		}
	}

}
