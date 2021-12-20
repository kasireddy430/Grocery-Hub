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


@WebServlet("/Productlist")

public class Productlist extends HttpServlet {

	/* Console Page Displays all the Products  */
	ArrayList<Product> Productlist = new ArrayList<Product>();    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       try{

            Productlist = MySqlDataStoreUtilities.getallproducts();
			System.out.println("printing all products"+Productlist);
		}
		catch(Exception e)
		{

		}
			System.out.println("After catch"+Productlist);

        request.setAttribute("Productlist",Productlist);
        request.getRequestDispatcher("allproducts.jsp").forward(request,response);
    }
}