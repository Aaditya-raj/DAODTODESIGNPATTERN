package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.dao.RegisterDAO;
import master.dto.RegisterDTO;

/**
 * Servlet implementation class RegisterDelServe
 */
public class RegisterDelServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String uname=request.getParameter("uname");
		RegisterDTO rdto=new RegisterDTO();
		rdto.setUname(uname);
		RegisterDAO rdao = new RegisterDAO();
		rdao.deleteData(rdto);
		//response.sendRedirect("Del.jsp");
		response.sendRedirect("Show.jsp");
	}

}
