package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.MessagesSoapClient;
import service.ws.ApplicationException_Exception;
import service.ws.Message;

public class GetChat extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ((boolean) request.getSession().getAttribute("isLogged")) {
			String friend = request.getParameter("friend");
			
			try {
				request.setAttribute("friend", friend);
				List<Message> lista = MessagesSoapClient.getMessages((String) request.getSession().getAttribute("user"), friend);
				request.setAttribute("messageList", lista);
				getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}
		} else getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
