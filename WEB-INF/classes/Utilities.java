import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;

@WebServlet("/Utilities")

/* 
	Utilities class contains class variables of type HttpServletRequest, PrintWriter,String and HttpSession.

	Utilities class has a constructor with  HttpServletRequest, PrintWriter variables.
	  
*/

public class Utilities extends HttpServlet{
	HttpServletRequest req;
	PrintWriter pw;
	String url;
	HttpSession session; 
	public Utilities(HttpServletRequest req, PrintWriter pw) {
		this.req = req;
		this.pw = pw;
		this.url = this.getFullURL();
		this.session = req.getSession(true);
	}

public boolean isLoggedin(){
    if (session.getAttribute("username")==null)
        return false;
    return true;
}

public void logout(){
        session.removeAttribute("username");
        session.removeAttribute("usertype");
        session.removeAttribute("login_msg");
        session.removeAttribute("zipCode");
    }

public String username(){
        if (session.getAttribute("username")!=null){
            System.out.println(session.getAttribute("username"));
            return session.getAttribute("username").toString();
        }
        else{
        return null;
            }
    }

public String getFullURL() {
    String scheme = req.getScheme();
    String serverName = req.getServerName();
    int serverPort = req.getServerPort();
    String contextPath = req.getContextPath();
    StringBuffer url = new StringBuffer();
    url.append(scheme).append("://").append(serverName);

    if ((serverPort != 80) && (serverPort != 443)) {
        url.append(":").append(serverPort);
    }
    url.append(contextPath);
    url.append("/");
    return url.toString();
}
public void storeProduct(String id,String image,String name,Double quantity, Double price, String category){
    System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiii"+username());
    OrdersHashMap.orders.containsKey(username());

    if(!OrdersHashMap.orders.containsKey(username())){ 
            ArrayList<OrderItem> arr = new ArrayList<OrderItem>();
            OrdersHashMap.orders.put(username(), arr);
        }
        ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
        HashMap<String,Foods> allfoods = new HashMap<String,Foods> (); 
         HashMap<String,Foods> allpchb = new HashMap<String,Foods> (); 
         HashMap<String,Foods> allbeverages = new HashMap<String,Foods> (); 
         HashMap<String,Foods> allbcb = new HashMap<String,Foods> (); 
HashMap<String,Foods> allhousehold = new HashMap<String,Foods> ();


        if(category.equals("food")){
            Foods foods;
            try{
                allfoods = MySqlDataStoreUtilities.getFoodItems();
            }
            catch(Exception e){
                System.out.println(e);
            }
                        // System.out.println(allfoods);

            foods = allfoods.get(id);
            // System.out.println("llllllllllllllllllllllllllllllllll"+foods);
            OrderItem orderitem = new OrderItem(foods.getproduct_image(), foods.getproduct_name(), quantity, price,foods.getproduct_discount(),category,foods.getproduct_id());
            orderItems.add(orderitem);
         // System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+orderItems);   
        }

        if(category.equals("pchb")){
            Foods foods;
            try{
                allpchb = MySqlDataStoreUtilities.getPchbItems();
            }
            catch(Exception e){
                System.out.println(e);
            }
                        // System.out.println(allfoods);

            foods = allpchb.get(id);
            // System.out.println("llllllllllllllllllllllllllllllllll"+foods);
            OrderItem orderitem = new OrderItem(foods.getproduct_image(), foods.getproduct_name(), quantity, price,foods.getproduct_discount(),category,foods.getproduct_id());
            orderItems.add(orderitem);
         // System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+orderItems);   
        }

        if(category.equals("beverages")){
            Foods foods;
            try{
                allbeverages = MySqlDataStoreUtilities.getBeveragesItems();
            }
            catch(Exception e){
                System.out.println(e);
            }
                        // System.out.println(allfoods);

            foods = allbeverages.get(id);
            // System.out.println("llllllllllllllllllllllllllllllllll"+foods);
            OrderItem orderitem = new OrderItem(foods.getproduct_image(), foods.getproduct_name(), quantity, price,foods.getproduct_discount(),category,foods.getproduct_id());
            orderItems.add(orderitem);
         // System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+orderItems);   
        }

        if(category.equals("household")){
            Foods foods;
            try{
                allhousehold = MySqlDataStoreUtilities.getHouseholdItems();
            }
            catch(Exception e){
                System.out.println(e);
            }
                        System.out.println(allhousehold+"rrrrrrrrrrrrrrrrrrrrrr");

            foods = allhousehold.get(id);
             // System.out.println("llllllllllllllllllllllllllllllllll"+foods);
            OrderItem orderitem = new OrderItem(foods.getproduct_image(), foods.getproduct_name(), quantity, price,foods.getproduct_discount(),category,foods.getproduct_id());
            orderItems.add(orderitem);
          // System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+orderItems);   
        }

        if(category.equals("bcb")){
            Foods foods;
            try{
                allbcb = MySqlDataStoreUtilities.getBcbItems();
            }
            catch(Exception e){
                System.out.println(e);
            }
                        System.out.println(allbcb+"rrrrrrrrrrrrrrrrrrrrrr");

            foods = allbcb.get(id);
             System.out.println("llllllllllllllllllllllllllllllllll"+foods);
            OrderItem orderitem = new OrderItem(foods.getproduct_image(), foods.getproduct_name(), quantity, price,foods.getproduct_discount(),category,foods.getproduct_id());
            orderItems.add(orderitem);
          System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+orderItems);   
        }


}

    public ArrayList<OrderItem> getCustomerOrders(){
        ArrayList<OrderItem> order = new ArrayList<OrderItem>(); 
        if(OrdersHashMap.orders.containsKey(username()))
            order= OrdersHashMap.orders.get(username());
        return order;
    }

    public int CartCount(){
        if(isLoggedin())
        return getCustomerOrders().size();
        return 0;
    }

    public void removeItemFromCart(String itemName) {
        ArrayList<OrderItem> orderItems = OrdersHashMap.orders.get(username());
        System.out.println("llllllllllllllllllllll"+orderItems);
        int index = 0;
        for (OrderItem oi : orderItems) {
            if (oi.getName().equals(itemName)) {
                System.out.println(oi.getName()+" hello"+oi.getName().equals(itemName));
                break;
            } else index++;
        }
        System.out.println(index);
    
        orderItems.remove(index);
        System.out.println("pppppppppppppppp"+orderItems);
        }
    
        /*  getOrdersPaymentSize Function gets  the size of OrderPayment */
        public int getOrderPaymentSize(){
            HashMap<Integer, ArrayList<OrderPayment>> orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
                try
                {
                    
                    orderPayments = MySqlDataStoreUtilities.selectOrder();
                }
                catch(Exception e)
                {
                
                }
                int size=0;
                for(Map.Entry<Integer, ArrayList<OrderPayment>> entry : orderPayments.entrySet()){
                         size=size + 1;
                         
                }
                return size;        
        }
    
        // store the payment details for orders
        public void storePayment(int userId,String customerName,String email,String userAddress,String creditCardNo,double discount,int orderId,LocalDate orderDate,LocalDate shippingDate,String orderName,String category,double orderPrice,String storeId,String storeAddress,String zipcode,String orderDeliveredOnTime,String transactionStatus,int review){
            HashMap<Integer, ArrayList<OrderPayment>> orderPayments= new HashMap<Integer, ArrayList<OrderPayment>>();
            //  // get the payment details file 
                try
                {
            
                    orderPayments = MySqlDataStoreUtilities.selectOrder();
                }
                catch(Exception e)
                {
                
                }
                if(orderPayments==null)
                {
                    orderPayments = new HashMap<Integer, ArrayList<OrderPayment>>();
                }
          
    
                try
                {   
                    
                    Date orderDate1 = java.sql.Date.valueOf(orderDate);
                    Date shippingDate1 = java.sql.Date.valueOf(shippingDate); 
                    MySqlDataStoreUtilities.insertOrder(userId,customerName,email,userAddress,creditCardNo,discount,orderId,orderDate1,shippingDate1,orderName,category,orderPrice,storeId,storeAddress,zipcode,orderDeliveredOnTime,transactionStatus,review);
    
    
                }
                catch(Exception e)
                {
                    System.out.println("inside exception file not written properly");
                }   
        }
}