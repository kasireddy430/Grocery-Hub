import java.io.*;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;

import java.sql.*;

import java.io.IOException;
import java.io.*;



public class AjaxUtility {
    StringBuffer sb = new StringBuffer();
    boolean namesAdded = false;
    static Connection conn = null;
    static String message;
    public static String getConnection()
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project?useUnicode=true&characterEncoding=utf8", "root", "root");                          
            message="Successfull";
            return message;
        }
        catch(SQLException e)
        {
             message="unsuccessful";
             return message;
        }
        catch(Exception e)
        {
             message="unsuccessful";
             return message;
        }
    }

    public  StringBuffer readdata(String searchId)
    {
        HashMap<String,Product> data;
        data=getData();

        Iterator it = data.entrySet().iterator();
        
        System.out.println(it.hasNext());
        while (it.hasNext())
        {
                    Map.Entry pi = (Map.Entry)it.next();
                    
            if(pi!=null)
            {
                Product p=(Product)pi.getValue();
                
                if (p.getproduct_name().toLowerCase().startsWith(searchId))
                {
                        sb.append("<product>");
                        sb.append("<id>" + p.getproduct_id() + "</id>");
                        sb.append("<productName>" + p.getproduct_name() + "</productName>");
                        sb.append("</product>");
                }
            }
       }
       return sb;
    }

    public static HashMap<String,Product> getData()
    {
        HashMap<String,Product> hm=new HashMap<String,Product>();
        try
        {
            getConnection();

            String selectproduct="select * from groceryhub ";
            PreparedStatement pst = conn.prepareStatement(selectproduct);
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {   
                Product p = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getString("product_description"),rs.getDouble("product_currentprice"),rs.getInt("product_discount"),rs.getDouble("product_actualprice"),rs.getString("product_category"),rs.getString("product_image"),rs.getString("product_manufacturer"),rs.getInt("inventory"),rs.getString("store_zipcode"),rs.getInt("rating"),rs.getString("product_condition"));
                hm.put(rs.getString("product_id"), p);
            }
        }
        catch(Exception e)
        {
            System.out.println("execption handled");
            e.printStackTrace();
        }
        return hm;
    }
    public static void storeData(HashMap<String,Product> productdata)
    {
        try
        {

            getConnection();

            String insertIntoProductQuery = "INSERT INTO grocery_food(product_id,product_name,product_description,product_currentprice,product_discount,product_actualprice,product_category,product_image,product_manufacturer,inventory,store_zipcode,rating) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
            for(Map.Entry<String, Product> entry : productdata.entrySet())
            {

                PreparedStatement pst = conn.prepareStatement(insertIntoProductQuery);
                //set the parameter for each column and execute the prepared statement
                pst.setInt(1,entry.getValue().getproduct_id());
                pst.setString(2,entry.getValue().getproduct_name());
                pst.setString(3,entry.getValue().getproduct_name());
                pst.setDouble(4,entry.getValue().getproduct_currentprice());
                pst.setInt(5,entry.getValue().getproduct_discount());
                pst.setDouble(6,entry.getValue().getproduct_actualprice());
                pst.setString(7,entry.getValue().getproduct_category());
                pst.setString(8,entry.getValue().getproduct_image());
                pst.setString(9,entry.getValue().getproduct_manufacturer());
                pst.setInt(10,entry.getValue().getinventory());
                pst.setString(11,entry.getValue().getstore_zipcode());
                pst.setInt(12,entry.getValue().getrating());
                pst.execute();
            }
        }
        catch(Exception e)
        {

        }
    }

}
