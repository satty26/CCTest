package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddDao {
	String url = "jdbc:mysql://localhost:3306/saty?autoReconnect=true&useSSL=false";
	String username = "root";
	String password = "220778Sa@";
	public int addDetails(String empid, String jbrole, String monsal, String ybonus) throws ClassNotFoundException {
		String sql = "INSERT INTO SatyamGarg_111915116_salary" + " (Employee_ID_Number, Job_Role, Monthly_Salary, Yearly_Bonus) VALUES " + " (?,?,?,?);";
		int rs = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, empid);
			st.setString(2, jbrole);
			st.setString(3, monsal);
			st.setString(4, ybonus);
			
			System.out.println(st);
			rs = st.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return rs;
	}
}
