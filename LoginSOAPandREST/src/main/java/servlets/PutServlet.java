package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.UserBusinessLogic;
import utility.StringUtil;

public class PutServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		boolean admin = request.getParameter("admin") != null;
		
		if (!StringUtil.isEmptyOrNull(password)) {
			try {
				UserBusinessLogic.editUser(nome, password, admin);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
}
