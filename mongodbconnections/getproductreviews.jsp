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
String username=request.getParameter("productname");
String date=request.getParameter("date");
String rating = request.getParameter("rating");
String feedback = request.getParameter("feedback");
System.out.println("i am here"+username);
Mongo mg = new Mongo("Localhost",27017);
DB db = mg.getDB("test");
DBCollection collection = db.getCollection("Reviews");
BasicDBObject doc = new BasicDBObject("name",request.getParameter("productname"));
DBCursor cursor = collection.find(doc);
System.out.println(cursor);			
	
%>	
