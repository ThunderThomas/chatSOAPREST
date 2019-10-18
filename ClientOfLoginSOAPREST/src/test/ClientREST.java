package test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import service.ws.User;

public class ClientREST {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/LoginSOAPandREST/jaxrs");
		
		WebTarget userTarget = target.path("users");
		
		Invocation.Builder invocationBuilder = userTarget.request(MediaType.APPLICATION_JSON);
		
		User persona = new User();
		persona.setNome("Tommaso");
		persona.setPassword("Tommaso1");
		persona.setAdmin(true);
		
		invocationBuilder.post(Entity.entity(persona, MediaType.APPLICATION_JSON));
		invocationBuilder = userTarget.request(MediaType.APPLICATION_JSON);
		
		Response response = invocationBuilder.get();
		
		List<User> users = response.readEntity( new GenericType<List<User>>() {});
		for (User u : users) {
			System.out.println(u.getNome() + " " + u.getPassword());
		}
		System.out.println();
		
		Invocation.Builder invocationBuilder2 = userTarget.path("Tommaso").request(MediaType.APPLICATION_JSON);
		response = invocationBuilder2.get();
		User utente = response.readEntity(User.class);
		System.out.println(utente.getNome() + " " + utente.getPassword());
		System.out.println();
		
		persona.setPassword("Cosa");
		invocationBuilder.put(Entity.entity(persona, MediaType.APPLICATION_JSON));
		response = invocationBuilder2.get();
		utente = response.readEntity(User.class);
		System.out.println(utente.getNome() + " " + utente.getPassword());
		System.out.println();
		
		invocationBuilder2.delete();
		invocationBuilder = userTarget.request(MediaType.APPLICATION_JSON);
		response = invocationBuilder.get();
		users = response.readEntity( new GenericType<List<User>>() {});
		for (User u : users) {
			System.out.println(u.getNome() + " " + u.getPassword());
		}
	}

}
