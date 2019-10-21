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

import bl.UserBusinessLogic;
import models.User;

@Path("users")
public class UserREST {
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() throws ClassNotFoundException, SQLException, NamingException {
		return UserBusinessLogic.getAll();
	}
	
	@GET
	@Path("/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("nome") String nome) throws ClassNotFoundException, SQLException, NamingException {
		return UserBusinessLogic.getUser(nome);
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addUser (User user) throws ClassNotFoundException, SQLException, NamingException {
		return UserBusinessLogic.addUser(user.getNome(), user.getPassword(), user.isAdmin());
	}
	
	@PUT
	@Path("/")
	public boolean editUser (User user) throws ClassNotFoundException, SQLException, NamingException {
		return UserBusinessLogic.editUser(user.getNome(), user.getPassword(), user.isAdmin());
	}
	
	@DELETE
	@Path("/{nome}")
	public boolean deleteUser(@PathParam("nome") String nome) throws ClassNotFoundException, SQLException, NamingException {
		return UserBusinessLogic.deleteUser(nome);
	}
	
}
