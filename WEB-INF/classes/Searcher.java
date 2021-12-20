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

@WebServlet("/Searcher")

public class Searcher extends HttpServlet {

	/* Console Page Displays all the Consoles and their Information in Game Speed */
	ArrayList<Foods> searchlist = new ArrayList<Foods>();

	
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       try{
           String x = (String)request.getParameter("searchId");
           System.out.println(x+"po ra poooka");
         searchlist = MySqlDataStoreUtilities.getSearch(x);
          System.out.println(x+"po ra poooka");  

        
		}
		catch(Exception e)
		{

		}
	    request.setAttribute("Foodslist",searchlist);
        request.getRequestDispatcher("Searcher.jsp").forward(request,response);
	
    }

}