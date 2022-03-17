package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	String sql = "select * from SatyamGarg_111915116_cc where Employee_ID_Number=? and Pass=?";
	String sqlc = "select * from SatyamGarg_111915116_cc where Employee_ID_Number=?";
	String url = "jdbc:mysql://localhost:3306/saty?autoReconnect=true&useSSL=false";
	 
	String username = "root";
	String password = "220778Sa@";
	public boolean check(String uname, String pass) {
		
		try {
			System.out.println(sql);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,  uname);
			st.setString(2, pass);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	public boolean checkPresent(String uname) {
			
			try {
				System.out.println(sqlc);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement st = con.prepareStatement(sqlc);
				st.setString(1,  uname);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					return true;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return false;
		}
}
