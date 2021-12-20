import java.io.IOException;
import java.io.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/* 
	OrderPayment class contains class variables username,ordername,price,image,address,creditcardno.

	OrderPayment  class has a constructor with Arguments username,ordername,price,image,address,creditcardno
	  
	OrderPayment  class contains getters and setters for username,ordername,price,image,address,creditcardno
*/

public class OrPayment implements Serializable{
	private int userId;
	private String customerName;
	private String email;
private String userAddress;
private String creditCardNo;
private double discount;
	private int orderId;
private Date orderTime;
private Date shippingDate;
	
	private String orderName;
	private String category;
	private double orderPrice;
	private String storeId;
	private String storeAddress;
	private String zipcode;
	private String deliveredOnTime;
	private String transactionStatus;
	private int review;
	
	
	public OrPayment(int userId,String customerName,String email,String userAddress,String creditCardNo,int discount,int orderId,Date orderTime,Date shippingDate,String orderName,String category,double orderPrice,String storeId,String storeAddress,String zipcode,String deliveredOnTime,String transactionStatus,int review){
		this.userId=userId;
		this.customerName=customerName;
		this.email=email;
		this.userAddress=userAddress;
		this.creditCardNo=creditCardNo;
		this.discount=discount;
		this.orderId=orderId;
		this.orderTime=orderTime;
		this.shippingDate=shippingDate;
		this.orderName=orderName;
		this.category=category;
	 	this.orderPrice=orderPrice;		
		this.storeId=storeId;
		this.storeAddress=storeAddress;
		this.zipcode=zipcode;
		this.deliveredOnTime=deliveredOnTime;
		this.transactionStatus=transactionStatus;
		this.review=review;
		}

	// public OrPayment(int orderId, String orderName, double orderPrice) {
	// 		this.orderId = orderId;
	// 		this.orderName = orderName;
	// 		this.orderPrice = orderPrice;
	// 	}
 //    public OrPayment(int orderId, String orderName, double orderPrice, int saleAmount) {
 //        this.orderId = orderId;
 //        this.orderName = orderName;
 //        this.orderPrice = orderPrice;
 //        this.saleAmount = saleAmount;
	// }
	// public OrPayment(String orderName, double orderPrice, int saleAmount) {
 //        this.orderName = orderName;
 //        this.orderPrice = orderPrice;
 //        this.saleAmount = saleAmount;
	// }
	// public OrPayment(int saleAmount, Date orderTime) {
 //        this.saleAmount = saleAmount;
 //        this.orderTime = orderTime;
	// }

	// public Date getOrderTime() {
 //        return orderTime;
 //    }

 //    public void setOrderTime(Date orderTime) {
 //        this.orderTime = orderTime;
	// }
	// public int getSaleAmount() {
 //        return saleAmount;
 //    }

 //    public void setSaleAmount(int saleAmount) {
 //        this.saleAmount = saleAmount;
 //    }
    
	// public String getUserAddress() {
	// 	return userAddress;
	// }

	// public void setUserAddress(String userAddress) {
	// 	this.userAddress = userAddress;
	// }

	// public String getCreditCardNo() {
	// 	return creditCardNo;
	// }

	// public void setCreditCardNo(String creditCardNo) {
	// 	this.creditCardNo = creditCardNo;
	// }

	public String getOrderName() {
		return orderName;
	}

	// public void setOrderName(String orderName) {
	// 	this.orderName = orderName;
	// }

	// public String getUserName() {
	// 	return userName;
	// }

	// public void setUserName(String userName) {
	// 	this.userName = userName;
	// }

	public int getOrderId() {
		return orderId;
	}

	// public void setOrderId(int orderId) {
	// 	this.orderId = orderId;
	// }


	public double getOrderPrice() {
		return orderPrice;
	}

	// public void setOrderPrice(double orderPrice) {
	// 	this.orderPrice = orderPrice;
	// }

	// public String getstoreAddress() {
	// 	return storeAddress;
	// }

	// public void setstoreAddress(String storeAddress) {
	// 	this.storeAddress = storeAddress;
	// }

	// public String getStoreId() {
	// 	return storeId;
	// }

	// public void setStoreId(String storeId) {
	// 	this.storeId = storeId;
	// }

	// public double getTotalSales() {
	// 	return totalSales;
	// }

	// public void setTotalSales(double totalSales) {
	// 	this.totalSales = totalSales;
	// }


	// public double getDiscount() {
	// 	return discount;
	// }

	// public void setDiscount(double discount) {
	// 	this.discount = discount;
	// }

	// public double getShippingCost() {
	// 	return shippingCost;
	// }

	// public void setShippingCost(double shippingCost) {
	// 	this.shippingCost = shippingCost;
	// }

	// public int getQuantity() {
	// 	return quantity;
	// }

	// public void setQuantity(int quantity) {
	// 	this.quantity = quantity;
	// }

	// public String getCategory() {
	// 	return category;
	// }

	// public void setCategory(String category) {
	// 	this.category = category;
	// }

	public String getCustomerName() {
		return customerName;
	}

	// public void setCustomerName(String customerName) {
	// 	this.customerName = customerName;
	// }

	// public LocalDate getShippingDate() {
	// 	return shippingDate;
	// }

	// public void setShippingDate(LocalDate shippingDate) {
	// 	this.shippingDate = shippingDate;
	// }

	// public LocalDate getOrderDate() {
	// 	return orderDate;
	// }

	// public void setOrderDate(LocalDate orderDate) {
	// 	this.orderDate = orderDate;
	// }
}