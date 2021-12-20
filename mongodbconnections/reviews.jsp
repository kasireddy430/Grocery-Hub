
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
     import="com.mongodb.BasicDBObject"
     import="com.mongodb.DB"
     import="com.mongodb.DBCollection"
     import="com.mongodb.DBCursor"
     import="com.mongodb.MongoClient"
     import="java.net.UnknownHostException"
	 import="com.sun.org.apache.bcel.internal.generic.NEW"
	 import="com.mongodb.DBObject"
	 import="com.mongodb.Mongo"
      %> 


<% 
String username=request.getParameter("name");
String date=request.getParameter("date");
String rating = request.getParameter("rating");
String feedback = request.getParameter("feedback");
System.out.println(username);
Mongo mg = new Mongo("Localhost",27017);
DB db = mg.getDB("test");
DBCollection collection = db.getCollection("Reviews");
BasicDBObject doc = new BasicDBObject();
DBCursor cursor = collection.find();
doc = new BasicDBObject();

            doc.append("Name",request.getParameter("name"));
            doc.append("productName",request.getParameter("productname"));
            doc.append("Product id",request.getParameter("productid"));
			doc.append("date",request.getParameter("date"));
            doc.append("reviewRating",request.getParameter("rating"));
            doc.append("feedback",request.getParameter("feedback"));
            doc.append("zipCode",session.getAttribute("zipCode"));
			collection.insert(doc);
			mg.close();

response.sendRedirect("../index.jsp");			
	
%>	
