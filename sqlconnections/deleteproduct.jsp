<%@ page import ="java.sql.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.io.IOException" %>
<%@ page import ="java.util.ArrayList" %>

    <%

    String productID = request.getParameter("productID");    
  
    System.out.println(productID);
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
    Statement st=conn.createStatement();
    int i=st.executeUpdate("delete from groceryhub where product_id='"+productID+"'");
    response.sendRedirect("../ProductModify.jsp");
    }
    catch(Exception e)
    {
    System.out.print(e);
    e.printStackTrace();
    }
    %>