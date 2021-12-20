<%@ page import ="java.sql.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.io.IOException" %>
<%@ page import ="java.util.ArrayList" %>

    <%

    String id = request.getParameter("productID"); 
    int productID=Integer.parseInt(id); 
    String productName = request.getParameter("productName");
    String productDes = request.getParameter("productDes");
    String cprice = request.getParameter("productCPrice");
            double productCPrice = Double.parseDouble(cprice); 
    String dis = request.getParameter("productDis");
    int productDis=Integer.parseInt(dis); 
    String aprice = request.getParameter("productAPrice");
            double productAPrice = Double.parseDouble(aprice); 
    String productCat = request.getParameter("productCat");
    String productImg = request.getParameter("productImg");
    String productMan = request.getParameter("productMan");
    String inv = request.getParameter("productInv");
    int productInv=Integer.parseInt(inv);
    String productZip = request.getParameter("productZip");
    String rating = request.getParameter("productRating");
    int productRating=Integer.parseInt(rating); 
    String productCondition ="NEW";  
    
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
    Statement st=conn.createStatement();
    int i=st.executeUpdate("insert into groceryhub(product_id,product_name,product_description,product_currentprice,product_discount,product_actualprice,product_category,product_image,product_manufacturer,inventory,store_zipcode,rating,product_condition)values('"+productID+"','"+productName+"','"+productDes+"','"+productCPrice+"','"+productDis+"','"+productAPrice+"','"+productCat+"','"+productImg+"','"+productMan+"','"+productInv+"','"+productZip+"','"+productRating+"','"+productCondition+"')");
    
    response.sendRedirect("../ProductModify.jsp");
    }
    catch(Exception e)
    {
    System.out.print(e);
    e.printStackTrace();
    }
    %>