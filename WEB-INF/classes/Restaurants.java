import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Map;

@WebServlet("/Restaurants")

/* 
	FitnessWatch class contains class variables name,price,image,retailer,condition,discount.

	FitnessWatch class has a constructor with Arguments name,price,image,retailer,condition,discount.
	  
	FitnessWatch class contains getters and setters for name,price,image,retailer,condition,discount.
*/

public class Restaurants extends HttpServlet{
	private String name;
	private String contactno;
	private String image;
	private String url;
	private String rating;
	
	public Restaurants(String name,  String image, String contactno,String url, String rating){
		this.name=name;
		this.image=image;
		this.contactno=contactno;
		this.url = url;
		this.rating = rating;
	}
	
	public Restaurants(){
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geturl() {
		return url;
	}
	public void seturl(String url) {
		this.url = url;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getcontactno() {
		return "12345";
	}
	public void setcontactno(String contactno) {
		this.contactno = contactno;
	}

	public String getrating() {
		return "5.0";
	}

	public void setrating(String rating) {
		this.rating = rating;
	}

}
