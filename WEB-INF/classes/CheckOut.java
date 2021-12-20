import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.sql.*;

@WebServlet("/CheckOut")

//once the user clicks buy now button page is redirected to checkout page where user has to give checkout information

public class CheckOut extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	      Utilities Utility = new Utilities(request, pw);
		storeOrders(request, response);
	}
	
	protected void storeOrders(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try
        {
        response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
        Utilities utility = new Utilities(request,pw);
		if(!utility.isLoggedin())
		{
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to add items to cart");
			response.sendRedirect("login.jsp");
			return;
		}
        HttpSession session=request.getSession(); 

		//get the order product details	on clicking submit the form will be passed to submitorder page	
		
	    String userName = session.getAttribute("username").toString();
        String orderTotal = request.getParameter("orderTotal");
		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navbar.jsp").include(request, response);

		pw.print("<form name ='CheckOut' action='Payment' method='post' style='max-width: 800px;margin: auto;background: white;padding: 20px;'>");
        pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<p style='font-size: 24px;'>Order Details</p>");
		pw.print("</h2><div class='entry'>");
		pw.print("<table  class='gridtable' border='1' style='text-align:center;'><tr><td>User Name:</td><td>");
		pw.print(userName);
		pw.print("</td></tr>");
		// for each order iterate and display the order name price
		for (OrderItem oi : utility.getCustomerOrders()) 
		{
			pw.print("<tr><td> Product Purchased:</td><td>");
			pw.print(oi.getName()+"</td></tr><tr><td>");
			double quantPrice = 0.0;
			quantPrice = oi.getQuantity() * oi.getPrice();
			pw.print("<input type='hidden' name='orderPrice' value='"+quantPrice+"'>");
			pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
			pw.print("Product Price:</td><td>"+ quantPrice);
			pw.print("</td></tr>");
		}
		pw.print("<tr><td>");
        pw.print("Total Order Cost : </td><td>"+orderTotal);
		pw.print("<input type='hidden' name='orderTotal' value='"+orderTotal+"'>");
		pw.print("</td></tr></table><table><tr></tr><tr></tr>");	


		pw.print("<br>");
		pw.print("<h3>Billing Information:</h3>");
		pw.print("<table  width='100%'>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label>Full Name:</label></td>");
		pw.print("<td><input type='text' name='customerName'  size='70'> </td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label>Email:</label></td>");
		pw.print("<td><input type='email' name='email'  size='70'> </td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >Address: </label></td>");
		pw.print("<td><input type='text' name='address'   size='70'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >City: </label></td>");
		pw.print("<td><input type='text'  name='city'  size='70'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label>Zip Code: </label></td>");
		pw.print("<td><input type='text' name='zipcode'  size='70'></td></tr> ");
		pw.print("<tr><td></td><td></td><td></td><td><br><label>State: </label></td>");
		pw.print("<td><input type='text' name='state'   size='70'></td></tr>");
		
		pw.print("</table>");
		pw.print("<h3>Payment Details:</h3>");
		pw.print("<table  width='100%'>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >Name On The Card: </label></td>");
		pw.print("<td><input type='text' name='cardName'  size='50'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >Credit Card No: </label></td>");
		pw.print("<td><input type='text' name='creditCardNo'  size='50'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >Exp Month: </label></td>");
		pw.print("<td><input type='text' name='expMonth'  size='50'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >CVV: </label></td>");
		pw.print("<td><input type='text' name='cvv'  size='50'></td></tr>");
		pw.print("<tr><td></td><td></td><td></td><td><br><label >Exp Year: </label></td>");
		pw.print("<td><input type='text' name='expYear'  size='50'></td></tr>");
		pw.print("</table>");
				pw.print("<h3>Delivery Type:</h3>");

		pw.print("<table>");

		pw.print("<tr><td><select name='deliveryoption'>");
		pw.print("<option value= 'homedelivery'>Home Delivery</option>");
		pw.print("<option value= 'storepickup'>Store Pickup</option>");
		
		pw.print("</select></td></tr>");
		pw.print("</table>");
		pw.print("<table>");
		pw.print("<div width='100%'></div><div width='100%'></div><div width='100%'></div><div width='100%'></div>");

        pw.print("<tr><td><label>");
        pw.print("<input type='checkbox' checked='checked' name='checkbox' required> Proceed to payment. ");
        pw.print("</label></td></tr>");
		pw.print("</table>");
		pw.print("<input type='submit' name='submit' class='btnbuy'>");
		pw.print("</div></div></div>");
		pw.print("</form>");


		request.getRequestDispatcher("footer.jsp").include(request, response);	
	    }
        catch(Exception e)
		{
         System.out.println(e.getMessage());
		}  			
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	    {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	    }
}