import java.io.IOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DealMatchesUtilities")

public class DealMatchesUtilities extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

			HashMap<String,Product> selectedproducts=new HashMap<String,Product>();
		try
			{
		pw.print("<div style='background-color:white;text-align: center; width:200%' id='content'>");
		pw.print("<div class='post'>");
		pw.print("<h2 class='title'>");
		pw.print("<a href='#'>Welcome to GROCERY HUB </a></h2>");

		pw.print("<div class='entry'>");
		pw.print("<img src='images/main.png'style='width: 600px; display: block; margin-left: auto; margin-right: auto' />");
		pw.print("<h1 style='color:red'>We beat our competitors in all aspects. Price-Match Guaranteed</h2>");

			String line=null;
			String TOMCAT_HOME = System.getProperty("catalina.home");

			HashMap<String,Product> productmap=MySqlDataStoreUtilities.getData();

			for(Map.Entry<String, Product> entry : productmap.entrySet())
			{

			if(selectedproducts.size()<2 && !selectedproducts.containsKey(entry.getKey()))
			{


			BufferedReader reader = new BufferedReader(new FileReader (new File(TOMCAT_HOME+"\\webapps\\project\\DealMatches.txt")));
			line=reader.readLine().toLowerCase();
//
			
			if(line==null)
			{
				pw.print("<h2 align='center'>No Offers Found</h2>");
				break;
			}
			else
			{
			do {

				  if(line.contains(entry.getKey()))
				  {

					pw.print("<h3>"+line+"</h3>");
					pw.print("<br>");
					selectedproducts.put(entry.getKey(),entry.getValue());
					System.out.println(entry.getValue().getproduct_name());
					break;
				  }

			    }while((line = reader.readLine()) != null);

			 }
			 }
			}
			}
			catch(Exception e)
			{
			// pw.print("<h2 align='center'>No Offers Found</h2>");
			}
			

			pw.print("</div>");
		pw.print("</div>");
		pw.print("<div class='post'>");
		pw.print("<h2 class='title meta'>");
		pw.print("<a style='font-size: 24px;'>Deal Matches</a>");
		pw.print("</h2>");
		pw.print("<div class='entry'>");
		if(selectedproducts.size()==0)
		{
		pw.print("<h2 align='center'>No Deals Found</h2>");
		}
		else
		{
		pw.print("<table style='text-align: center;margin-left: auto;margin-right: auto;background-color:white;' id='bestseller'>");
		pw.print("<tr>");
		for(Map.Entry<String, Product> entry : selectedproducts.entrySet()){
		pw.print("<td><div id='shop_item'><h3>"+entry.getValue().getproduct_name()+"</h3>");
		pw.print("<strong>"+entry.getValue().getproduct_currentprice()+"$</strong>");
		System.out.println(entry.getValue().getproduct_image()+"hi");
		pw.print("<ul>");
		pw.print("<img src='"+entry.getValue().getproduct_image()+"' alt='' width='200' height='200' />");
		
		pw.print("<form action='product.jsp' method='post'><input type='submit' class='btnbuy' value='Buy Now' style='background-color: #DB7093;border: none;color: white;padding: 10px 20px;text-decoration: none; margin: 4px 2px;cursor: pointer;font-style: italic;border-radius: 12px;'>");
		pw.print("<input type='hidden' name='product_id' value='"+entry.getValue().getproduct_id()+"'>");
		pw.print("<input type='hidden' name='product_name' value='"+entry.getKey()+"'>");
		pw.print("<input type='hidden' name='product_description' value='"+entry.getValue().getproduct_description()+"'>");
		pw.print("<input type='hidden' name='product_currentprice' value='"+entry.getValue().getproduct_currentprice()+"'>");
		pw.print("<input type='hidden' name='product_discount' value='"+entry.getValue().getproduct_discount()+"'>");
		pw.print("<input type='hidden' name='product_actualprice' value='"+entry.getValue().getproduct_actualprice()+"'>");
		pw.print("<input type='hidden' name='product_category' value='"+entry.getValue().getproduct_category()+"'>");
		pw.print("<input type='hidden' name='product_image' value='"+entry.getValue().getproduct_image()+"'>");
		pw.print("<input type='hidden' name='product_manufacturer' value='"+entry.getValue().getproduct_manufacturer()+"'>");
		pw.print("<input type='hidden' name='inventory' value='"+entry.getValue().getinventory()+"'>");
		pw.print("<input type='hidden' name='store_zipcode' value='"+entry.getValue().getstore_zipcode()+"'>");
		pw.print("<input type='hidden' name='rating' value='"+entry.getValue().getrating()+"'>");

		// <input type="hidden" name = "product_id" value="${foodslist.product_id}">
  //                               <input type="hidden" name = "product_name" value="${foodslist.product_name}">
  //                               <input type="hidden" name = "product_description" value="${foodslist.product_description}">
  //                               <input type="hidden" name = "product_currentprice" value="${foodslist.product_currentprice}">
  //                               <input type="hidden" name = "product_discount" value="${foodslist.product_discount}">
  //                               <input type="hidden" name = "product_actualprice" value="${foodslist.product_actualprice}">
  //                               <input type="hidden" name = "product_category" value="${foodslist.product_category}">
  //                               <input type="hidden" name = "product_image" value="${foodslist.product_image}">
  //                               <input type="hidden" name = "product_manufacturer" value="${foodslist.product_manufacturer}">
  //                               <input type="hidden" name = "inventory" value="${foodslist.inventory}">
  //                               <input type="hidden" name = "store_zipcode" value="${foodslist.store_zipcode}">
  //                               <input type="hidden" name = "rating" value="${foodslist.rating}">

		pw.print("<input type='hidden' name='access' value=''>");
		pw.print("</form>");
		
		pw.print("</ul></div></td>");
		}
		pw.print("</tr></table>");
		}
		pw.print("</div></div></div>");

	}
}
