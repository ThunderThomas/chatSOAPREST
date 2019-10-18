package service.rs;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import bl.MessageBusinessLogic;
import models.Message;

@Path("messages")
public class MessageREST {

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addMessage(Message messaggio) throws ClassNotFoundException, SQLException, NamingException {
		return MessageBusinessLogic.addMessage(messaggio.getMittente(), messaggio.getDestinatario(),
				messaggio.getTesto());
	}

	@GET
	@Path("/{user}/{friend}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@PathParam("user") String user, @PathParam("friend") String friend)
			throws ClassNotFoundException, SQLException, NamingException {
		return MessageBusinessLogic.getMessages(user, friend);
	}

	@PUT
	@Path("/")
	public boolean editMessage(Message messaggio) throws ClassNotFoundException, SQLException, NamingException {
		return MessageBusinessLogic.editMessage(messaggio.getId(), messaggio.getTesto());
	}

	@DELETE
	@Path("/")
	public boolean deleteMessage(int id) throws ClassNotFoundException, SQLException, NamingException {
		return MessageBusinessLogic.deleteMessage(id);
	}
}
