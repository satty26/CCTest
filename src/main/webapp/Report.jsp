<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/saty?autoReconnect=true&useSSL=false";
String username="root";
String password = "220778Sa@";
String sql ="select * from SatyamGarg_111915116_cc";

try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<style> 
input[type=text], input[type=password], select {
  width: 40%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=submit] {
  background-color: #04AA6D;
  border: none;
  color: white;
  padding: 16px 32px;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
<meta charset="ISO-8859-1">
<title>Employee Records</title>
</head>
<body>

<h1>Here are records for all the employees</h1>
<table border="1">
<tr>
<td>Employee ID</td>
<td>First name</td>
<td>Last name</td>
<td>DOB</td>
<td>Contact</td>

</tr>
<%
try{
connection = DriverManager.getConnection(url, username, password);
statement=connection.createStatement();
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("Employee_ID_Number") %></td>
<td><%=resultSet.getString("First_Name") %></td>
<td><%=resultSet.getString("Last_Name") %></td>
<td><%=resultSet.getString("Date_of_Birth") %></td>
<td><%=resultSet.getString("Contact_Number") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> 
<br>
<h2>Search for employee information</h2>
	<form action="Retrieve" method="post">
		 Enter Employee ID : <input type="text" name="empid"><br>
		 <input type="submit" value="Find">
	</form>
<h2>Add employee information</h2>
	<form action="Record" method="post">
		 Enter Employee ID : <input type="text" name="emp_id"><br>
		 Enter Job Role: <input type="text" name="jbrole"><br>
		 Enter Monthly Salary : <input type="text" name="monsal"><br>
		 Enter Yearly Bonus : <input type="text" name="ybonus"><br>
		 <input type="submit" value="Add">
	</form>
</body>
</html>