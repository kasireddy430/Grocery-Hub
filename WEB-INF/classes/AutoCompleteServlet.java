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


@WebServlet("/autocomplete")

public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
   
  String searchId=null;	

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();

	    }

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException 
	{
		try
		{	
			String action = request.getParameter("action");
            searchId = request.getParameter("searchId");
            System.out.println(searchId+"jjj"+action);
			StringBuffer sb = new StringBuffer();
			if (searchId != null && action.equals("complete")) {
				searchId = searchId.trim().toLowerCase();
			} 
			System.out.println(searchId+": searchId");
			if(searchId==null)	
			{
				context.getRequestDispatcher("/Error").forward(request, response);
			}
			boolean namesAdded = false;
			if (action.equals("complete")) 
			{	
			// check if user sent empty string
				if (!searchId.equals("")) 
				{
					AjaxUtility a=new AjaxUtility();
					sb=a.readdata(searchId);
					System.out.println(sb+"hello");
					if(sb!=null || !sb.equals(""))
					{
						namesAdded=true;
					}
					if (namesAdded) 
					{
						response.setContentType("text/xml");
						response.getWriter().write("<products>" + sb.toString() + "</products>");
						System.out.println(sb+"check this data");
					} 
					else 
					{
						//nothing to show
						response.setStatus(HttpServletResponse.SC_NO_CONTENT);
					}
				}
			}
			if (action.equals("lookup"))
			{
				
				HashMap<String,Product> data=AjaxUtility.getData(); 
				System.out.println("trimming"+searchId); 
				   	
				if ((searchId != null) && data.containsKey(searchId.trim())) 
				{
					request.setAttribute("data",data.get(searchId.trim()));	
					System.out.println("lllllllllllll"+data.get(searchId.trim()));
					String x = data.get(searchId.trim()).getproduct_name();
					int y = data.get(searchId.trim()).getproduct_id();
					String z = data.get(searchId.trim()).getproduct_description();
					Double a = data.get(searchId.trim()).getproduct_currentprice();
					int b = data.get(searchId.trim()).getproduct_discount();
					Double c = data.get(searchId.trim()).getproduct_actualprice();
					String d = data.get(searchId.trim()).getproduct_category();
					String e = data.get(searchId.trim()).getproduct_image();
					String f = data.get(searchId.trim()).getproduct_manufacturer();
					int g = data.get(searchId.trim()).getinventory();
					String h = data.get(searchId.trim()).getstore_zipcode();
					int i = data.get(searchId.trim()).getrating();
					System.out.println(x+"oooooooooo");
					request.setAttribute("product_name",x);
					request.setAttribute("product_id",y);
					request.setAttribute("product_description",z);
					request.setAttribute("product_currentprice",a);
					request.setAttribute("product_discount",b);
					request.setAttribute("product_actualprice",c);
					request.setAttribute("product_category",d);
					
					request.setAttribute("product_image",e);
					request.setAttribute("product_manufacturer",f);
					request.setAttribute("inventory",g);
					request.setAttribute("store_zipcode",h);
					request.setAttribute("rating",i);
					request.getRequestDispatcher("productdata.jsp").forward(request,response);
				}
			}
		}
		catch(Exception e)
		{
		}
    }
}