<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/saty?autoReconnect=true&useSSL=false";
String username="root";
String password = "220778Sa@";
String employee_name = session.getAttribute("searched_employee").toString();
String sql ="select * from SatyamGarg_111915116_salary where Employee_ID_Number=?";
System.out.println(employee_name);
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
<meta charset="ISO-8859-1">
<title>Employee Records</title>
</head>
<body>

<h1>Here are records for all the employees</h1>
<table border="1">
<tr>
<td>Employee ID</td>
<td>Job Role</td>
<td>Monthly salary</td>
<td>Yearly Bonus</td>

</tr>
<%
try{
connection = DriverManager.getConnection(url, username, password);
statement=connection.createStatement();
PreparedStatement st = connection.prepareStatement(sql);
st.setString(1, employee_name);
resultSet = st.executeQuery();
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("Employee_ID_Number") %></td>
<td><%=resultSet.getString("Job_Role") %></td>
<td><%=resultSet.getString("Monthly_Salary") %></td>
<td><%=resultSet.getString("Yearly_Bonus") %></td>

</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
</body>
</html>