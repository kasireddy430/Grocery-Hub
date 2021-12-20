import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import java.util.*;
import java.text.*;


import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import java.util.*;
import java.io.*;


@WebServlet("/Beverageslist")

public class Beverageslist extends HttpServlet {

	/* Console Page Displays all the Consoles and their Information in Game Speed */
	ArrayList<Foods> beverageslist = new ArrayList<Foods>();
	String reviewslist;
 
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Review> flatArray  = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request,pw);
       try{

       	HttpSession session = request.getSession(true);	
				
				String x =(String) session.getAttribute("foodslistname");
				String zip = (String)session.getAttribute("zipCode");
				System.out.println(x+"hhhhhhhhhhhhh"+zip);
				if(x !=null){
					System.out.println(x+"kkkkkkkkkkkkk"+zip);
					beverageslist = MySqlDataStoreUtilities.getBeverages(x);
				}else if(zip != null){
					System.out.println(x+"lllllllllllllllllllllllll"+zip);
					beverageslist = MySqlDataStoreUtilities.getBeverages(zip);
					} 
					HashMap<String, ArrayList<Review>> hm = MongoDBDataStoreUtilities.selectReview();


			 
			 Collection<ArrayList<Review>> values = hm.values();
  			 ArrayList<ArrayList<Review>> listOfValues  = new ArrayList<>(values); 
  			listOfValues.forEach(flatArray::addAll); 			
  			 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+flatArray);
				
		}
		catch(Exception e)
		{
			System.out.println(e+"hhhhhhhhhhhhhhhhhhhhhhh");
		}
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to view products");
			response.sendRedirect("login.jsp");
			return;
		}
		System.out.println(beverageslist.size()+"choosukoni ra ra");
		if(beverageslist.size()==0){
			
				request.getRequestDispatcher("header.jsp").include(request, response);
				request.getRequestDispatcher("navbar.jsp").include(request, response);
				pw.print("<div style='background-color:white;' id='content'>");
				pw.print("<h3 style='color:red'>Sorry For The Inconvinience, We don't serve in your location. Kindly Select another Location. </h3>");
				pw.print("<div></div><div></div><div></div><div></div><div></div><div></div>");
				pw.print("<br><br><br><br>");	
				pw.print("<br><br><br><br>");	

				pw.print("</div>");
				return;	
		}
			System.out.println("After catch"+beverageslist);
			HttpSession session = request.getSession(); 
		session.setAttribute("Reviews",flatArray);
        request.setAttribute("Foodslist",beverageslist);
        request.getRequestDispatcher("beverages.jsp").forward(request,response);
    }
}