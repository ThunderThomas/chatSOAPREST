package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.MessagesSoapClient;
import service.ws.ApplicationException_Exception;

public class DeleteMessage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if ((boolean) request.getSession().getAttribute("isLogged")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String friend = request.getParameter("friend");
			try {
				MessagesSoapClient.deleteMessage(id);
				request.setAttribute("friend", friend);
				request.setAttribute("messageList",
						MessagesSoapClient.getMessages((String) request.getSession().getAttribute("user"), friend));
				getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}
		} else
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}
	
}
