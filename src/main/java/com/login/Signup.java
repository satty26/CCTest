package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.LoginDao;
import com.login.dao.SignupDao;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String cnum = request.getParameter("cnum");
		
		SignupDao dao = new SignupDao();
		
		try {
			dao.signupEmployee(uname,pass,fname,lname,dob,cnum);
			HttpSession session = request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("Report.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
