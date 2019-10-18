package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.UsersSoapClient;
import service.ws.ApplicationException_Exception;
import service.ws.User;
import utility.BooleanUtil;
import utility.StringUtil;

public class GetSOAP extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (BooleanUtil.isTrue((Boolean) request.getSession().getAttribute("isLogged"))) {
			String nome = request.getParameter("nome");
			User user = null;

			if (!StringUtil.isEmptyOrNull(nome)) {
				try {
					user = UsersSoapClient.getUser(nome);
				} catch (ApplicationException_Exception e) {
					e.printStackTrace();
				}
			}

			request.setAttribute("user", user);
			try {
				request.setAttribute("list", UsersSoapClient.getAll());
			} catch (ApplicationException_Exception e) {
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} else
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}
}
