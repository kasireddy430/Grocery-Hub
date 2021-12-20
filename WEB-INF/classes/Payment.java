import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.text.DateFormat;  
import java.util.*;
import java.util.Random;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

@WebServlet("/Payment")

public class Payment extends HttpServlet {
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// String Customername = "";
		// String msg = "good";
		
        ArrayList<Restaurants> restaurantslist = new ArrayList<Restaurants>();
        try{

			restaurantslist = MySqlDataStoreUtilities.getRestaurants();
			System.out.println("RESTAURANTLIST:"+restaurantslist);
		}
		catch(Exception e)
		{

		}
		Utilities utility = new Utilities(request, pw);
		if(!utility.isLoggedin())
		{			
			
			HttpSession session = request.getSession(true);	session.setAttribute("login_msg", "Please Login to Pay");
			response.sendRedirect("Login");
			return;
		}
		// get the payment details like credit card no address processed from cart servlet	
		String customerName=request.getParameter("customerName");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
		String userAddress=address+", "+city+", "+state+", "+zipcode;

		String creditCardNo=request.getParameter("creditCardNo");

		
		String deliveryoption=request.getParameter("deliveryoption");
		
		String ts=request.getParameter("orderTotal");
		Double totalSales=Double.parseDouble(ts);
				
		
	// if (deliveryoption.equals("storepickup"))
	// {		
	// 	if(!userAddress.isEmpty() && !creditCardNo.isEmpty() ){
			
	// 		//System.out.println("Hi hello namaste");
	// 		ArrayList<StoreInfo> stores = new ArrayList<StoreInfo>();
	// 		try
	// 		{
	// 			stores=MySqlDataStoreUtilities.selectStoreInfo();

	// 		}
	// 		catch(Exception e){
	// 			System.out.println(e);
	// 		}
			
	// 		utility.printHtml("Header.html");
	// 		utility.printHtml("LeftNavigationBar.html");
	// 		pw.print("<form name = 'Home' action ='Home' method='post'>");
		
	// 		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
	// 		pw.print("<a style='font-size: 24px;'><h2>STORE PICKUP</h2></a>");
	// 		pw.print("</h2><div class='entry'>");	
	// 		pw.print("<br><table  class='gridtable'>");
	// 			pw.print("<tr><td></td>");
	// 			pw.print("<td>StoreId: </td>");
	// 			pw.print("<td>StoreAddress: </td>");
	// 			pw.print("<td>ZipCode: </td>");
	// 			pw.print("<input type='hidden' name='totalSales' value='"+totalSales+"'>");
	// 			pw.print("<input type='hidden' name='customerName' value='"+customerName+"'>");
	// 			pw.print("<input type='hidden' name='customerAge' value='"+customerAge+"'>");
	// 			pw.print("<input type='hidden' name='creditCardNo' value='"+creditCardNo+"'>");
	// 			pw.print("<input type='hidden' name='userAddress' value='"+zipcode+"'>");
	// 			pw.print("<input type='hidden' name='userAddress' value='"+userAddress+"'>");
	// 			for(StoreInfo st : stores)
	// 			{
	// 				pw.print("<tr><td><input type='radio' name='location' value = '"+st.getStoreId()+"/"+st.getstoreAddress()+"'></td>");
	// 				pw.print("<td>"+st.getStoreId()+"</td>");
	// 				pw.print("<td>"+st.getstoreAddress()+"</td>");
	// 				pw.print("<td>"+st.getzipCode()+"</td>");
	// 			}
	// 			pw.print("<tr><td></td><td></td><td></td><td><input type='submit' name ='submit' value='submit'</td></tr>");
	// 			pw.print("</form></table>");
	// 		pw.print("</h3></div></div></div>");		
	// 		utility.printHtml("Footer.html");		
	// 	}
		
	// 	else
	// 	{
	// 		utility.printHtml("Header.html");
	// 		utility.printHtml("LeftNavigationBar.html");
	// 		pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
	// 		pw.print("<a style='font-size: 24px;'>Order</a>");
	// 		pw.print("</h2><div class='entry'>");
		
	// 		pw.print("<h4 style='color:red'>Details are not provided properly</h4>");
	// 		pw.print("</h2></div></div></div>");		
	// 		utility.printHtml("Footer.html");
	// 	}
		
	// }	
		if (deliveryoption.equals("storepickup"))
		{
		  if(!userAddress.isEmpty() && !creditCardNo.isEmpty() )
			{
			System.out.println("hello prands");
			Random rand = new Random(); 
			int ConfirmationNo = rand.nextInt(10000000);
			int userId = rand.nextInt(1000);
			int assi = rand.nextInt(40);
			int review = rand.nextInt(5);
			int orderId=utility.getOrderPaymentSize()+assi;
			
			
			LocalDate orderDate = LocalDate.now();

			//add 2 week to the current date
			LocalDate shippingDate = orderDate.plus(2, ChronoUnit.WEEKS);
			LocalDate actualDate = orderDate.plus(1,ChronoUnit.WEEKS);
			String orderReturned;
			String orderDeliveredOnTime;
			int value = rand.nextInt(2);
			if(value==0){
				orderReturned = "No";
			}else{
				orderReturned = "Yes";
			}
			int value1 = rand.nextInt(2);
			if(value1==0){
				orderDeliveredOnTime = "No";
			}else{
				orderDeliveredOnTime = "Yes";
			}
			String transactionStatus;
			int value2 = rand.nextInt(2);
			if(value2==0){
				transactionStatus = "Disputed";
			}else{
				transactionStatus = "Approved";
			}
			int rev;
			if(review==0){
				rev = 1;
			}else{
				rev = review;
			}
			
			//iterate through each order

			for (OrderItem oi : utility.getCustomerOrders())
			{
				String deliveryTrackingId = oi.getName()+orderId;

				//set the parameter for each column and execute the prepared statement
				System.out.println();
				utility.storePayment(userId,customerName,email,userAddress,creditCardNo,oi.getDiscount(),orderId,orderDate,shippingDate,oi.getName(),oi.getCategory(),oi.getPrice(),"storepickup","storepickup",zipcode,orderDeliveredOnTime,transactionStatus,rev);
			}


			//remove the order details from cart after processing
			
			OrdersHashMap.orders.remove(utility.username());	
			request.getRequestDispatcher("header.jsp").include(request, response);
		    request.getRequestDispatcher("navbar.jsp").include(request, response);
			pw.print("<div id='content' style='max-width: 80%; margin: auto;background: white;padding: 20px;'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h2>Your Order");
			pw.print("&nbsp&nbsp");  
			pw.print("is stored ");
			pw.print("<br>Your Order No is "+(orderId));
			pw.print("<br>Your Order Confirmation No is "+(ConfirmationNo));
			pw.print("<br>Your Delivery Date is  "+(shippingDate));
            pw.print("</h2></div></div></div>");
            pw.print("<br><br><br>");
            System.out.println("qqqqqqqhgfyufgyjyfgfgjfvu yt568y5t87");
            request.setAttribute("Restaurantslist",restaurantslist);
            request.getRequestDispatcher("corousel.jsp").include(request,response);
            pw.print("<br><br><br>");		
			request.getRequestDispatcher("footer.jsp").include(request, response);	
			}
		 else
			{
			request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navbar.jsp").include(request, response);
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h4 style='color:red'>Please enter all valid details</h4>");
            pw.print("</h2></div></div></div>");
            pw.print("<br><br><br>");
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+restaurantslist);
            request.setAttribute("Restaurantslist",restaurantslist);
            request.getRequestDispatcher("corousel.jsp").include(request,response);
                pw.print("<br><br><br><br><br><br>");
            request.getRequestDispatcher("footer.jsp").include(request, response);	
            
            
			}
			
		}
 

	if (deliveryoption.equals("homedelivery"))
		{
		  if(!userAddress.isEmpty() && !creditCardNo.isEmpty() )
			{
			System.out.println("hello prands");
			Random rand = new Random(); 
			int ConfirmationNo = rand.nextInt(10000000);
			int userId = rand.nextInt(1000);
			int assi = rand.nextInt(40);
			int review = rand.nextInt(5);
			int orderId=utility.getOrderPaymentSize()+assi;
			
			
			LocalDate orderDate = LocalDate.now();

			//add 2 week to the current date
			LocalDate shippingDate = orderDate.plus(2, ChronoUnit.WEEKS);
			LocalDate actualDate = orderDate.plus(1,ChronoUnit.WEEKS);
			String orderReturned;
			String orderDeliveredOnTime;
			int value = rand.nextInt(2);
			if(value==0){
				orderReturned = "No";
			}else{
				orderReturned = "Yes";
			}
			int value1 = rand.nextInt(2);
			if(value1==0){
				orderDeliveredOnTime = "No";
			}else{
				orderDeliveredOnTime = "Yes";
			}
			String transactionStatus;
			int value2 = rand.nextInt(2);
			if(value2==0){
				transactionStatus = "Disputed";
			}else{
				transactionStatus = "Approved";
			}
			int rev;
			if(review==0){
				rev = 1;
			}else{
				rev = review;
			}
			
			//iterate through each order

			for (OrderItem oi : utility.getCustomerOrders())
			{
				String deliveryTrackingId = oi.getName()+orderId;

				//set the parameter for each column and execute the prepared statement
				System.out.println();
				utility.storePayment(userId,customerName,email,userAddress,creditCardNo,oi.getDiscount(),orderId,orderDate,shippingDate,oi.getName(),oi.getCategory(),oi.getPrice(),"homedelivery","homedelivery",zipcode,orderDeliveredOnTime,transactionStatus,rev);
			}


			//remove the order details from cart after processing
			
			OrdersHashMap.orders.remove(utility.username());	
			request.getRequestDispatcher("header.jsp").include(request, response);
		    request.getRequestDispatcher("navbar.jsp").include(request, response);
			pw.print("<div id='content' style='max-width: 80%; margin: auto;background: white;padding: 20px;'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h2>Your Order");
			pw.print("&nbsp&nbsp");  
			pw.print("is stored ");
			pw.print("<br>Your Order No is "+(orderId));
			pw.print("<br>Your Order Confirmation No is "+(ConfirmationNo));
			pw.print("<br>Your Delivery Date is  "+(shippingDate));
            pw.print("</h2></div></div></div>");
            pw.print("<br><br><br>");
            System.out.println("qqqqqqqhgfyufgyjyfgfgjfvu yt568y5t87");
            request.setAttribute("Restaurantslist",restaurantslist);
            request.getRequestDispatcher("corousel.jsp").include(request,response);
            pw.print("<br><br><br>");		
			request.getRequestDispatcher("footer.jsp").include(request, response);	
			}
		 else
			{
			request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navbar.jsp").include(request, response);
			pw.print("<div id='content'><div class='post'><h2 class='title meta'>");
			pw.print("<a style='font-size: 24px;'>Order</a>");
			pw.print("</h2><div class='entry'>");
		
			pw.print("<h4 style='color:red'>Please enter all valid details</h4>");
            pw.print("</h2></div></div></div>");
            pw.print("<br><br><br>");
            System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+restaurantslist);
            request.setAttribute("Restaurantslist",restaurantslist);
            request.getRequestDispatcher("corousel.jsp").include(request,response);
                pw.print("<br><br><br><br><br><br>");
            request.getRequestDispatcher("footer.jsp").include(request, response);	
            
            
			}
			
		}
	}	


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);
		
		
	}
}