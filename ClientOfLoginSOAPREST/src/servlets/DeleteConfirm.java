package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.BooleanUtil;

public class DeleteConfirm extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (BooleanUtil.isTrue((Boolean) request.getSession().getAttribute("isLogged"))) {
			getServletContext().getRequestDispatcher("/delete.jsp").forward(request, response);
		} else
			getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
