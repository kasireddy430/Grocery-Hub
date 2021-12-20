<%@ page import="com.myorg.Restaurants"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.ObjectOutputStream"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*"%>

%>



<%
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "project";
String userId = "root";
String password = "root";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font color="#FF00FF"><strong>Select query in JSP</strong></font></h2>
<table align="center" cellpadding="4" cellspacing="4">
<tr>

</tr>
<tr bgcolor="#008000">
<td><b>Name</b></td>
<td><b>Address</b></td>
<td><b>Destination </b></td>
<td><b>Salary</b></td>
<td><b>DateOfJoin</b></td>
</tr>
<%
try {
connection = DriverManager.getConnection(
connectionUrl + dbName, userId, password);
statement = connection.createStatement();
String sql = "SELECT * FROM morning";

resultSet = statement.executeQuery(sql);
String nameOfTextFile = "C:\\apache-tomcat-7.0.34\\webapps\\project\\data\\restaurants.txt";
try {   
    PrintWriter pw = new PrintWriter(new FileOutputStream(nameOfTextFile));
    pw.flush();
    pw.println(""+resultSet);
    pw.close();
} catch(IOException e) {
    System.out.println(e.getMessage());
}
System.out.println("this is the one"+resultSet);
%>

<%
while (resultSet.next()) {
%>
<tr bgcolor="#8FBC8F">
<td><%=resultSet.getString("name")%></td>
<td><%=resultSet.getString("image")%></td>
<td><%=resultSet.getString("contactno")%></td>
<td><%=resultSet.getString("url")%></td>
<td><%=resultSet.getString("rating")%></td>
</tr>

<%
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>