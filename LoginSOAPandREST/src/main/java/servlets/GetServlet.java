package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.UserBusinessLogic;
import models.User;
import utility.StringUtil;

public class GetServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		User user = null;
		String nome = request.getParameter("nome");
		
		
		if (!StringUtil.isEmptyOrNull(nome)) {
			try {
				user = UserBusinessLogic.getUser(nome);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
