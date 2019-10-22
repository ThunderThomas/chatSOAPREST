package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clients.UsersSoapClient;
import service.ws.ApplicationException_Exception;
import utility.BooleanUtil;

public class DeleteSOAP extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (BooleanUtil.isTrue((Boolean) request.getSession().getAttribute("isLogged"))) {
			if ((boolean) request.getSession().getAttribute("isAdmin")) {
				String nome = request.getParameter("nome");
				String nomeVero = request.getParameter("nomeVero");

				if (nome.equals(nomeVero)) {
					try {
						UsersSoapClient.deleteUser(nome);
					} catch (ApplicationException_Exception e) {
						e.printStackTrace();
					}
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
