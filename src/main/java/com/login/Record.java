package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.login.dao.AddDao;

@WebServlet("/Record")
public class Record extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String empid = request.getParameter("emp_id");
		String jbrole = request.getParameter("jbrole");
		String monsal = request.getParameter("monsal");
		String ybonus = request.getParameter("ybonus");
		
		AddDao dao = new AddDao();
		try {
			dao.addDetails(empid, jbrole, monsal, ybonus);
			HttpSession session = request.getSession();
			response.sendRedirect("Report.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
