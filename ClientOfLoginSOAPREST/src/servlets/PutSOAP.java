package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.UsersSoapClient;
import service.ws.ApplicationException_Exception;
import utility.BooleanUtil;
import utility.StringUtil;

public class PutSOAP extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (BooleanUtil.isTrue((Boolean) request.getSession().getAttribute("isLogged"))) {
			if ((boolean) request.getSession().getAttribute("isAdmin")) {
				String nome = request.getParameter("nome");
				String password = request.getParameter("password");
				boolean admin = request.getParameter("admin") != null;
	
				if (!StringUtil.isEmptyOrNull(password)) {
					try {
						UsersSoapClient.editUser(nome, password, admin);
					} catch (ApplicationException_Exception e) {
						e.printStackTrace();
					}
				}
				
				if (request.getSession().getAttribute("user").equals(nome)) {
					request.getSession().setAttribute("isAdmin", admin);
				}
			}
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
