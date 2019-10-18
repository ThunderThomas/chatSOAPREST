package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clients.UsersSoapClient;
import service.ws.ApplicationException_Exception;
import utility.StringUtil;

public class CheckLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("noUserOrPassword", false);
		session.setAttribute("wrongUserOrPassword", false);

		if (StringUtil.isEmptyOrNull(username) || StringUtil.isEmptyOrNull(password)) {
			session.setAttribute("noUserOrPassword", true);
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		} else
			try {
				if (UsersSoapClient.login(username, password)) {
					session.setAttribute("isLogged", true);
					session.setAttribute("user", username);
					session.setAttribute("isAdmin", UsersSoapClient.getUser(username).isAdmin());
					request.setAttribute("userList", UsersSoapClient.getAll());
					getServletContext().getRequestDispatcher("/chat.jsp").forward(request, response);
				} else {
					session.setAttribute("wrongUserOrPassword", true);
					getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
				}
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}
	}
}
