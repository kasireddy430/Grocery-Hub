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
@WebServlet("/Dealslist")

public class Dealslist extends HttpServlet {

	/* Console Page Displays all the Consoles and their Information in Game Speed */
    ArrayList<Foods> dealslist = new ArrayList<Foods>();
    
	
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Review> flatArray  = new ArrayList<>();
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request,pw);
       try{

			dealslist = MySqlDataStoreUtilities.getDeals();
				HashMap<String, ArrayList<Review>> hm = MongoDBDataStoreUtilities.selectReview();


			 
			 Collection<ArrayList<Review>> values = hm.values();
  			 ArrayList<ArrayList<Review>> listOfValues  = new ArrayList<>(values); 
  			listOfValues.forEach(flatArray::addAll); 			
  			 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+flatArray);
			// System.out.println("khfvsrmjgtfdjycv,dsvfgxdhctmykv,guhkumhtgfedvfgbhnm,kjl");
		}
		catch(Exception e)
		{

		}
		if(!utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", "Please Login to view products");
			response.sendRedirect("login.jsp");
			return;
		}
		HttpSession session = request.getSession(); 
		session.setAttribute("Reviews",flatArray);	

        request.setAttribute("Foodslist",dealslist);
        request.getRequestDispatcher("food.jsp").include(request,response);
    }
}