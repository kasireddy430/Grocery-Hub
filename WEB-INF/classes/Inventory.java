import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

@WebServlet("/Inventory")
public class Inventory extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        displayInventory(request, response, pw);
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter pw = response.getWriter();
//        Utilities utility = new Utilities(request, pw);
//
//
//        HashMap<String, Product> hm = new HashMap<String, Product>();
//        String TOMCAT_HOME = System.getProperty("catalina.home");
//
//        //get the user details from file
//        try {
//            hm = MySqlDataStoreUtilities.selectInventory();
//        } catch (Exception e) {
// /
//        }
//    }

    protected void displayInventory(HttpServletRequest request,
                                    HttpServletResponse response, PrintWriter pw)
            throws ServletException, IOException {

        Utilities utility = new Utilities(request, pw);
        request.getRequestDispatcher("header.jsp").include(request, response);
        request.getRequestDispatcher("navbar.jsp").include(request, response);

        HashMap<String, Product> productMap = new HashMap<String, Product>();

        //Table of Inventory
        pw.print("<div style='background-color:white;text-align: center; padding: 20px; padding-bottom: 20px;' id='content'>");
        pw.print("<div class='post'>");
        pw.print("<u><h3 class='title'>");
        pw.print("Table of Product Inventory");
        pw.print("</h3></u>");
        pw.print("<div class='entry'>");

        pw.print("<table style='text-align: center;margin-left: auto;margin-right: auto;' class='gridtable' border='1'>");
        pw.print("<tr>");
        pw.print("<th>Product Name</th>");
        pw.print("<th>Product Category</th>");
        pw.print("<th>Price</th>");
        pw.print("<th>No.of items available in inventory</th>");
        pw.print("</tr>");


        try {
            productMap = MySqlDataStoreUtilities.selectInventory();
        } catch (Exception ignored) {
            pw.print("WRONG!!!");
        }

        for (Product product : productMap.values()) {

            pw.print("<tr>");
            pw.print("<td>" + product.getproduct_name() + "</td>" +
                "<td>" + product.getproduct_category() + "</td>" +
                    "<td>" + product.getproduct_currentprice() + "</td>" +
                    "<td>" + product.getinventory() + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div>");


        //Bar Chart of Inventory

        //////////<script>
        pw.println("<script type='text/javascript' src=\"https://www.gstatic.com/charts/loader.js\"></script>");
        pw.println("<script type='text/javascript'>");

        // Load the Visualization API and the corechart package.
        pw.println("google.charts.load('current', {'packages':['corechart']});");

        // Set a callback to run when the Google Visualization API is loaded.
        pw.println("google.charts.setOnLoadCallback(drawChart);");

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        pw.println("function drawChart() {");

        // Create the data table.
        pw.println("var data = new google.visualization.DataTable();");
        pw.println("data.addColumn('string', 'Product Name');");
        pw.println("data.addColumn('number', 'Inventory');");
        pw.println(" data.addRows([");
        for (Product product : productMap.values()) {

            pw.println(" ['" + product.getproduct_name() + "', " + product.getinventory() + "],");
             /*pw.println(" ['Mushrooms', 3],");
              pw.println("['Onions', 1],");n
            pw.println("  ['Olives', 1],");
            pw.println("  ['Zucchini', 1],");
            pw.println("  ['Pepperoni', 2]  ");*/
        }
        pw.println("]);");
        // Set chart options
        pw.println(" var options = {'title':'Inventory',");
        pw.println("        'width':700,");
        pw.println("       'height':800};");

        // Instantiate and draw our chart, passing in some options.
        pw.println(" var chart = new google.visualization.BarChart(document.getElementById('chart_div'));");
        
        pw.println("  chart.draw(data, options);     }");
        pw.println(" </script>");

        /////////</script>


        //pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<u><h3 class='title'>");
        pw.print("Bar Chart of Inventory");
        pw.print("</h3></u>");
        pw.print("<div class='entry'>");
        pw.println("<div id='chart_div'></div>");

        pw.print("</div></div>");


        //Table of all products currently on sale
        //pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<u><h3 class='title'>");
        pw.print("Table of all products currently on sale");
        pw.print("</h3></u>");
        pw.print("<div class='entry'>");

        pw.print("<table style='text-align: center;margin-left: auto;margin-right: auto;' class='gridtable' border='1'>");
        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("</tr>");

        try {
            productMap = MySqlDataStoreUtilities.selectOnSale();
        } catch (Exception ignored) {
         pw.print("<tr><td>WRONG!!</td></tr>");
        }

        for (Product product : productMap.values()) {
           // pw.print("Hi");
            pw.print("<tr>");
            pw.print("<td> " + product.getproduct_name() + "</td>");
            pw.print("</tr>");

        }

        pw.print("</table></div></div>");


        //Table of all products currently that have manufacturer rebates
        //pw.print("<div id='content'>");
        pw.print("<div class='post'>");
        pw.print("<u><h3 class='title'>");
        pw.print("Table of all products currently that have manufacturer rebates");
        pw.print("</h3></u>");
        pw.print("<div class='entry'>");

        pw.print("<table style='text-align: center;margin-left: auto;margin-right: auto;' class='gridtable' border='1'>");
        pw.print("<tr>");
        pw.print("<td>Product Name</td>");
        pw.print("<td>Rebate</td>");
        pw.print("</tr>");
        try {
            productMap = MySqlDataStoreUtilities.selectRebate();
        } catch (Exception ignored) {

        }

        for (Product product : productMap.values()) {

            pw.print("<tr>");
            pw.print("<td>" + product.getproduct_name() + "</td>");
            pw.print("<td>" + product.getproduct_discount() + "</td>");
            pw.print("</tr>");

        }
        pw.print("</table></div></div><div class='clear'></div>");
       request.getRequestDispatcher("footer.jsp").include(request, response);   
    }
}
