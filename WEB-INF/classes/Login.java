import java.io.*;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")

public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		/* User Information(username,password,usertype) is obtained from HttpServletRequest,
		Based on the Type of user(customer,retailer,manager) respective hashmap is called and the username and 
		password are validated and added to session variable and display Login Function is called */

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		String us = request.getParameter("store");
		System.out.println("store address"+us);
		System.out.print("USER: "+username);
		System.out.println("PASS:"+password);

		HashMap<String, User> hm = new HashMap<String, User>();
		HashMap<String, OrderItem> or = new HashMap<String, OrderItem>();
		System.out.print("hashmap"+hm);
		String TOMCAT_HOME = System.getProperty("catalina.home");

		try {
			hm = MySqlDataStoreUtilities.selectUser();
		} catch (Exception e) {
				System.out.println(e);
		}

		User user = hm.get(username);
		User check = hm.get(password);
		
		System.out.print("hmuser"+user.getUsertype());
		System.out.println("hmusersdfsdfgdfgdfyer5ty"+check);

		if(user!=null )
		{
		 String user_password = user.getPassword();
			if (password.equals(user_password)) 
				{
				HttpSession session = request.getSession(true);
				session.setAttribute("username", user.getName());
				session.setAttribute("usertype", user.getUsertype());
				System.out.println("poooooooooooooooooooooo"+user.getZipCode());
				session.setAttribute("email",user.getEmail());
				session.setAttribute("zipCode",user.getZipCode());
				try {
					or = MySqlDataStoreUtilities.getAllOrders();
				} catch (Exception e) {
						System.out.println(e);
				}
				response.sendRedirect("index.jsp");
				return;
				}
			else{
				HttpSession session = request.getSession(false);
				System.out.print("wrong password");
				session.setAttribute("wrongpassword", true);
				request.getRequestDispatcher("login.jsp").forward(request,response);
				return;
			}
	}
	else{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}

	}
}

