import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

@WebServlet("/Registration")

public class Registration extends HttpServlet {
	private String error_msg;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	}

	/*   Username,Password,Usertype information are Obtained from HttpServletRequest variable and validates whether
		 the User Credential Already Exists or else User Details are Added to the Users HashMap */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Utilities utility = new Utilities(request, pw);

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("confirm-password");
        String usertype = request.getParameter("userType");
        String zipCode = request.getParameter("zipCode");
        String email = request.getParameter("email");
        System.out.println(username);
        System.out.println(password);
        System.out.println(repassword);
        System.out.println(usertype);

		// if(!utility.isLoggedin())
		// 	usertype = request.getParameter("usertype");


        if (!password.equals(repassword)) {
            error_msg = "Passwords doesn't match!";
        } 
        else {

            HashMap<String, User> hm = new HashMap<String, User>();

            try {
                hm = MySqlDataStoreUtilities.selectUser();
            } catch (Exception e) {
                    System.out.println(e);
            }

            System.out.println(usertype);
            // if the user already exist show error that already exist
            if (hm.containsKey(username))
                error_msg = "Username already exist as " + usertype;
            else {
				/*create a user object and store details into hashmap
				store the user hashmap into file  */

                User user = new User(username, password, usertype,zipCode,email);
                hm.put(username, user);
                System.out.println(usertype);
                if (MySqlDataStoreUtilities.insertUser(username, password, usertype,zipCode,email)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("login_msg", "Your " + usertype + " account has been created. Please login");
                    if (!utility.isLoggedin()) {
                        response.sendRedirect("login.jsp");
                        return;
                    } else {
                        response.sendRedirect("login.jsp");
                        return;
                    }
                }

            }
        }

		//display the error message
		if(utility.isLoggedin()){
			HttpSession session = request.getSession(true);				
			session.setAttribute("login_msg", error_msg);
			response.sendRedirect("Account"); return;
		}

	}


}
