package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.MessagesSoapClient;
import service.ws.ApplicationException_Exception;

public class GetChat extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((boolean) request.getSession().getAttribute("isLogged")) {
			String friend = request.getParameter("friend");
			try {
				request.setAttribute("messageList",
						MessagesSoapClient.getMessages((String) request.getSession().getAttribute("user"), friend));
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}

			getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
		} else
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
