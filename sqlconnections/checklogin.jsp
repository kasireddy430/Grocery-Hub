<!-- 

<%@ page import ="java.sql.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.io.IOException" %>
<%@ page import ="java.util.ArrayList" %>

    <%

    String userid = request.getParameter("username");    
    String pwd = request.getParameter("password");

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from login where user='"+userid+"' and pass='"+pwd+"'");
    ArrayList<String> loggeinuser = new ArrayList<String>();

    %> -->