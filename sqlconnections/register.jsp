<!-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
String usertype = request.getParameter("userType");
System.out.println(username);
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
Statement st=conn.createStatement();
int i=st.executeUpdate("insert into login(user,pass,usertype)values('"+username+"','"+password+"','"+usertype+"')");
response.sendRedirect("../login.jsp");
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
%>
 -->
