package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bl.UserBusinessLogic;

public class DeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		String nome = request.getParameter("nome");
		String nomeVero = request.getParameter("nomeVero");
		
		if (nome.equals(nomeVero)) {
			try {
				UserBusinessLogic.deleteUser(nome);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
