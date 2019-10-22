package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.MessagesSoapClient;
import service.ws.ApplicationException_Exception;

public class PostMessage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if ((boolean) request.getSession().getAttribute("isLogged")) {
			String destinatario = request.getParameter("destinatario");
			String testo = request.getParameter("testo");
			try {
				if (request.getParameter("id") != null) {
					int id = Integer.parseInt(request.getParameter("id"));
					MessagesSoapClient.replyMessage((String) request.getSession().getAttribute("user"), destinatario,
							testo, id);
				} else
					MessagesSoapClient.addMessage((String) request.getSession().getAttribute("user"), destinatario,
							testo);
				request.getSession().setAttribute("isReplying", false);
				request.setAttribute("friend", destinatario);
				request.setAttribute("messageList", MessagesSoapClient
						.getMessages((String) request.getSession().getAttribute("user"), destinatario));
				getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}
		} else
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
