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


@WebServlet("/Restaurantslist")

public class Restaurantslist extends HttpServlet {

	/* Console Page Displays all the Consoles and their Information in Game Speed */
    ArrayList<Restaurants> restaurantslist = new ArrayList<Restaurants>();
    
	
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
       try{

			restaurantslist = MySqlDataStoreUtilities.getRestaurants();
			// System.out.println("khfvsrmjgtfdjycv,dsvfgxdhctmykv,guhkumhtgfedvfgbhnm,kjl");
		}
		catch(Exception e)
		{

		}
			System.out.println("After catch aaaaaaaaaaaaaaaaaaaaaa"+restaurantslist);

        request.setAttribute("Restaurantslist",restaurantslist);
        request.getRequestDispatcher("corousel.jsp").include(request,response);
    }
}