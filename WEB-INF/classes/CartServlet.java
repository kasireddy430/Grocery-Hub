import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.lang.*;
import javax.swing.JCheckBox;

@WebServlet("/CartServlet")

public class CartServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
		PrintWriter pw = response.getWriter();


		/* From the HttpServletRequest variable name,type,maker and acessories information are obtained.*/

		Utilities utility = new Utilities(request, pw);
		String image = (String)request.getParameter("image");
		String name = request.getParameter("name");
		String q = request.getParameter("quantity");
		double quantity = Double.parseDouble(q);
		String id = request.getParameter("id");
		
		String p =(String)request.getParameter("price");
		double price = Double.parseDouble(p);
		String category = request.getParameter("category");

		/* StoreProduct Function stores the Purchased product in Orders HashMap.*/	
		System.out.println(id+"aaaaaaaaaaaaaaaa"+image+"bbbbbbbbbbb"+name+"ccccccccccc"+quantity+"ddddddddd"+price+"eeeeeeeee"+category);
		utility.storeProduct(id,image, name, quantity, price,category);
		displayCart(request, response);
	}
	

/* displayCart Function shows the products that users has bought, these products will be displayed with Total Amount.*/

	protected void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request,pw);
		Carousel carousel = new Carousel();
		
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to add items to cart");
			response.sendRedirect("login.jsp");
			return;
		}
		
		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navbar.jsp").include(request, response);
		pw.print("<div style='background-color:	#FFFFFF; padding: 20px;'>");
		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
		pw.print("<p style='font-size: 24px;'>Cart("+utility.CartCount()+")</p>");
		pw.print("</h2><div class='entry'>");
		pw.print("<form name ='Cart' action='CheckOut' method='post'>");
		if(utility.CartCount()>0)
		{
			pw.print("<table  class='gridtable' width='100%'>");
			int i = 1;
			double total = 0.0;
			double quantPrice = 0.0;
			double tax =0.0;
			double finalamount = 0.0;
		
				pw.print("<tr style='height:100px'>");
				pw.print("<th style='text-align:center'>Index</th><th></th><th></th><th></th><th></th><th style='text-align:center'>Product Image</th><th></th><th></th><th></th><th></th><th style='text-align:center'>Product Quantity</th><th style='text-align:center'>Product Name</th><th></th><th></th><th></th><th></th><th><th style='text-align:center'>Product Price</th>");
				pw.print("</tr>");
				for (OrderItem oi : utility.getCustomerOrders()) 
			{
				
				pw.print("<form action='RemoveCart' method='post'>");
				
				pw.print("<tr style='height:100px;width:80%;'>");
				quantPrice = oi.getQuantity() * oi.getPrice();
				pw.print("<input type='hidden' name='orderName' value='"+oi.getName()+"'>");
				pw.print("<input type='hidden' name='orderPrice' value='"+quantPrice+"'>");
				pw.print("<td style='text-align:center'>"+i+".</td><td></td><td></td><td></td><td></td><td style='text-align:center'><img src='"+oi.getImage()+"' alt='"+oi.getName()+"' width='10%' height='10%'> </td><td></td><td></td><td></td><td></td><td style='text-align:center'>"+oi.getQuantity()+"</td><td style='text-align:center'>"+oi.getName()+"</td><td></td><td></td><td></td><td></td><td><td style='text-align:center'> "+quantPrice+"</td>");
				pw.print("<td><input type='submit' name='RemoveCart' value='Remove'/></td>");
				
				pw.print("</tr>");
				pw.print("<tr style='height:60px'></tr>");
				pw.print("</form>");

				total = total +quantPrice;
				i++;
			}
				pw.print("<form action='CheckOut' method='post'>");
					
				tax = total*0.05;
								pw.print("<tr><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th style='text-align:center'>Tax(5%)</th><th></th><th></th><th></th><th></th><th></th><th style='text-align:center'>"+tax+"</th></tr>");
				finalamount = tax+total;
				pw.print("<tr><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th></th><th style='text-align:center'>Total</th><th></th><th></th><th></th><th></th><th></th><th style='text-align:center'>"+finalamount+"</th></tr>");
			pw.print("<tr><td></td><td></td><td></td><td><td><td></td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td style='text-align:center'><input type='submit' name='CheckOut' value='CheckOut' class='btnbuy' /></td></tr>");
			pw.print("<input type='hidden' name='orderTotal' value='"+finalamount+"'>");
			pw.print("</table></form>");
			pw.print("</div>");
			pw.print(carousel.carouselfeature(utility));
			/* This code is calling Carousel.java code to implement carousel feature*/
			// pw.print(carousel.carouselfeature(utility));
		}
		else
		{
			pw.print("<h4 style='color:red'>Your Cart is empty</h4>");
		}
		pw.print("<br><br>");
		pw.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");	
		request.getRequestDispatcher("footer.jsp").include(request, response);	
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		displayCart(request, response);
	}

}