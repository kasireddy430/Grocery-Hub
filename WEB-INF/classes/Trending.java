import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@WebServlet("/Trending")

public class Trending extends HttpServlet {

    ArrayList<Mostsold> mostsold = new ArrayList<Mostsold>();
    ArrayList<Mostsoldzip> mostsoldzip = new ArrayList<Mostsoldzip>();
    ArrayList<BestRating> bestrated = new ArrayList<BestRating>();

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        mostsold = MongoDBDataStoreUtilities.mostsoldProducts();
        System.out.println("mostsold size:" + mostsold.size());
        mostsoldzip = MongoDBDataStoreUtilities.mostsoldZip();
        System.out.println("mostsoldzip: "+mostsoldzip.size());
        bestrated = MongoDBDataStoreUtilities.topProducts();

        // for (Mostsoldzip mostsoldzip1: mostsoldzip){
        //     System.out.println(mostsoldzip1.getZipcode());
        //     System.out.println(mostsoldzip1.getCount());
        // }


        String name = "Trending";
        Utilities utility = new Utilities(request, pw);
        request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("navbar.jsp").include(request, response);
        pw.print("<div style='background-color: white; padding-top: 20px;'>");
        pw.print("<div style='padding-bottom: 20px; '");
        pw.print("<div id='content' style='display: flex; justify-content: center;'><div class='post'><h2 class='title meta'>");
        pw.print("<a style='font-size: 24px; display: flex; justify-content: center;'>Top 5 most liked products</a>");
        pw.print("</h2><div class='entry' style='display: flex; justify-content: center;'><table id='bestseller'>");
        Iterator itr2 = bestrated.iterator();
        System.out.println("hello world"+itr2);
        while (itr2.hasNext()) {
            BestRating best = (BestRating) itr2.next();
            pw.print("<tr>");
            pw.print("<td>");
            pw.print(best.getProductname().replace("_"," "));
            pw.print("</td>");
            pw.print("<div style='margin: 10px;'></div>");
            pw.print("<td>");
            pw.print(best.getRating());
            pw.print("</td>");
            pw.print("</tr>");
        }
        pw.print("</table></div></div></div>");

        pw.print("<div id='content' style='display: flex; justify-content: center;'><div class='post'><h2 class='title meta'>");
        pw.print("<a style='font-size: 24px; display: flex; justify-content: center;'>Top 5 zip-codes where maximum number of products sold</a>");
        pw.print("</h2><div class='entry' style='display: flex; justify-content: center;'><table id='bestseller'>");
        Iterator itr1 = mostsoldzip.iterator();
        while (itr1.hasNext()) {
            Mostsoldzip mostzip = (Mostsoldzip) itr1.next();
            pw.print("<tr>");
            pw.println("<td border: 1px >");
            System.out.println(mostzip.getZipcode());
            pw.println(mostzip.getZipcode());
            pw.println("</td>");
            pw.println("<td border: 1px >");
            pw.println(mostzip.getCount());
            pw.println("</td>");
            pw.println("</tr>");
        }
        pw.print("</table></div></div></div>");

        pw.print("<div id='content'><div class='post'><h2 class='title meta' style=' display: flex; justify-content: center;'>");
        pw.print("<a style='font-size: 24px;'>Top 5 most sold products regardless of the rating</a>");
        pw.print("</h2><div class='entry' style='display: flex; justify-content: center;'><table id='bestseller'>");

        Iterator itr = mostsold.iterator();
        while (itr.hasNext()) {
            Mostsold most = (Mostsold) itr.next();
            System.out.println(most.getProductname());
            pw.println("<tr>");
            pw.println("<td border: 1px >");
            pw.println(most.getProductname().replace("_"," "));
            pw.println("</td>");
            pw.println("<td border: 1px >");
            pw.println(most.getCount());
            pw.println("</td>");
            pw.println("</tr>");
        }

        pw.print("</table></div></div><br><br></div></div>");
        pw.print("</div>");

        request.getRequestDispatcher("footer.jsp").include(request, response);

        //	pw.print("</table></div></div></div>");
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

}
