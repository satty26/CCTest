package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SignupDao {
	String url = "jdbc:mysql://localhost:3306/saty?autoReconnect=true&useSSL=false";
	String username = "root";
	String password = "220778Sa@";
	public int signupEmployee(String uname, String pass, String fname, String lname, String dob, String cnum) throws ClassNotFoundException {
		String sql = "INSERT INTO SatyamGarg_111915116_cc" + " (Employee_ID_Number, First_Name, Last_Name, Date_of_Birth, Contact_Number, Pass) VALUES " + " (?,?,?,?,?,?);";
		int rs = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, fname);
			st.setString(3, lname);
			st.setString(4, dob);
			st.setString(5, cnum);
			st.setString(6, pass);
			
			System.out.println(st);
			rs = st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
}
