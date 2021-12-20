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

@WebServlet("/Foods")

/* 
	FitnessWatch class contains class variables name,price,image,retailer,condition,discount.

	FitnessWatch class has a constructor with Arguments name,price,image,retailer,condition,discount.
	  
	FitnessWatch class contains getters and setters for name,price,image,retailer,condition,discount.
*/

public class Foods extends HttpServlet{
	private int product_id;
	private String product_name;
	private String product_description;
	private Double product_currentprice;
	private int product_discount;
	private Double product_actualprice;
	private String product_category;
	private String product_image;
	private String product_manufacturer;
	private int inventory;
	private String store_zipcode;
	private int rating;
	private String product_condition;
	

	
	public Foods(int product_id,  String product_name, String product_description,Double product_currentprice, int product_discount, Double product_actualprice, String product_category, String product_image, String product_manufacturer, int inventory, String store_zipcode, int rating, String product_condition){
		this.product_id=product_id;
		this.product_name=product_name;
		this.product_description=product_description;
		this.product_currentprice = product_currentprice;
		this.product_discount = product_discount;
		this.product_actualprice=product_actualprice;
		this.product_category=product_category;
		this.product_image=product_image;
		this.product_manufacturer = product_manufacturer;
		this.inventory = inventory;
		this.store_zipcode = store_zipcode;
		this.rating = rating;
		this.product_condition = product_condition;
	}
	
	public Foods(){
		
	}
	
	public int getproduct_id() {
		return product_id;
	}
	public void setproduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getproduct_name() {
		return product_name;
	}
	public void setproduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getproduct_description() {
		return product_description;
	}
	public void setproduct_description(String product_description) {
		this.product_description = product_description;
	}
	public Double getproduct_currentprice() {
		return product_currentprice;
	}
	public void setproduct_currentprice(Double product_currentprice) {
		this.product_currentprice = product_currentprice;
	}

	public int getproduct_discount() {
		return product_discount;
	}

	public void setproduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}

	public Double getproduct_actualprice() {
		return product_actualprice;
	}
	public void setproduct_actualprice(Double product_actualprice) {
		this.product_actualprice = product_actualprice;
	}
	public String getproduct_category() {
		return product_category;
	}
	public void setproduct_category(String product_category) {
		this.product_category = product_category;
	}
	public String getproduct_image() {
		return product_image;
	}
	public void setproduct_image(String product_image) {
		this.product_image = product_image;
	}
	public String getproduct_manufacturer() {
		return product_manufacturer;
	}
	public void setproduct_manufacturer(String product_manufacturer) {
		this.product_manufacturer = product_manufacturer;
	}

	public int getinventory() {
		return inventory;
	}

	public void setinventory(int inventory) {
		this.inventory = inventory;
	}

	public String getstore_zipcode() {
		return store_zipcode;
	}
	public void setrating(String store_zipcode) {
		this.store_zipcode = store_zipcode;
	}
	public int getrating() {
		return rating;
	}
	public void setstore_zipcode(int rating) {
		this.rating = rating;
	}
		public String getproduct_condition() {
		return product_condition;
	}
	public void setproduct_condition(String product_condition) {
		this.product_condition = product_condition;
	}

}