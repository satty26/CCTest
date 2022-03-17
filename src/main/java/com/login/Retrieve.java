package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;

@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searched_name = request.getParameter("empid");
		LoginDao dao = new LoginDao();
		
		if(dao.checkPresent(searched_name)) {
			HttpSession session = request.getSession();
			session.setAttribute("searched_employee", searched_name);
			response.sendRedirect("Display.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
