import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import java.util.*;

public class MongoDBDataStoreUtilities {
    static DBCollection myReviews;

    public static DBCollection getConnection() {
        MongoClient mongo;
        mongo = new MongoClient("localhost", 27017);

        DB db = mongo.getDB("test");
        myReviews = db.getCollection("Reviews");
        System.out.print(myReviews);
        return myReviews;
    }

    public static void main(String[] args) {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }




    public static HashMap<String, ArrayList<Review>> selectReview() {
        HashMap<String, ArrayList<Review>> reviews = null;
        try {
        getConnection();
        DBCursor cursor = myReviews.find();
        reviews = new HashMap<String, ArrayList<Review>>();
        while (cursor.hasNext()) {
            BasicDBObject obj = (BasicDBObject) cursor.next();
            if (!reviews.containsKey(obj.getString("productName"))) {
                ArrayList<Review> arr = new ArrayList<Review>();
                reviews.put(obj.getString("productName"), arr);
            }
            ArrayList<Review> listReview = reviews.get(obj.getString("productName"));
            Review review = new Review(obj.getString("productName"), obj.getString("Name"), obj.getString("Product id"),
                    obj.getString("date"), obj.getString("reviewRating"), obj.getString("feedback"),obj.getString("zipCode"));
            //add to review hashmap
            listReview.add(review);

        }
        return reviews;
        }
        catch(Exception e){
            reviews = null;
            return reviews;
        }
        }
       

       public static ArrayList <Mostsold> mostsoldProducts(){
      ArrayList <Mostsold> mostsold = new ArrayList <Mostsold> ();
      try{
          
      
      getConnection();
      DBObject groupProducts = new BasicDBObject("_id","$productName"); 
      groupProducts.put("count",new BasicDBObject("$sum",1));
      DBObject group = new BasicDBObject("$group",groupProducts);
      DBObject limit=new BasicDBObject();
      limit=new BasicDBObject("$limit",5);
      
      DBObject sortFields = new BasicDBObject("count",-1);
      DBObject sort = new BasicDBObject("$sort",sortFields);
      AggregationOutput output = myReviews.aggregate(group,sort,limit);
      
      for (DBObject res : output.results()) {
      
      
       
        String prodcutname =(res.get("_id")).toString();
        String count = (res.get("count")).toString();   
        System.out.println("helooooooooooWorld"+count);
        Mostsold mostsld = new Mostsold(prodcutname,count);
        mostsold.add(mostsld);
    
      }
      
     
      
    }catch (Exception e){ System.out.println(e.getMessage());}
      return mostsold;
  } 

    public static ArrayList<Mostsoldzip> mostsoldZip() {
        ArrayList<Mostsoldzip> mostsoldzip = new ArrayList<Mostsoldzip>();
        try {
            System.out.println("top5");
            getConnection();
            DBObject groupProducts = new BasicDBObject("_id", "$zipCode");
            groupProducts.put("count", new BasicDBObject("$sum", 1));

           DBObject group = new BasicDBObject("$group", groupProducts);
            DBObject limit = new BasicDBObject();
            limit = new BasicDBObject("$limit", 5);

            DBObject sortFields = new BasicDBObject("count", -1);
            DBObject sort = new BasicDBObject("$sort", sortFields);
            AggregationOutput output = myReviews.aggregate(group, sort, limit);


            for (DBObject res : output.results()) {
                System.out.println(res);
                String zipcode = (res.get("_id")).toString();
                String count = (res.get("count")).toString();
                Mostsoldzip mostsldzip = new Mostsoldzip(zipcode, count);
                mostsoldzip.add(mostsldzip);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return mostsoldzip;
    }

        public static ArrayList<BestRating> topProducts() {
        ArrayList<BestRating> Bestrate = new ArrayList<BestRating>();
        try {

            getConnection();
            int retlimit = 5;
            DBObject sort = new BasicDBObject();
            sort.put("reviewRating", -1);
            DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
            while (cursor.hasNext()) {
                BasicDBObject obj = (BasicDBObject) cursor.next();

                String prodcutnm = obj.get("productName").toString();
                String rating = obj.get("reviewRating").toString();
                BestRating best = new BestRating(prodcutnm, rating);
                Bestrate.add(best);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Bestrate;
    }
  
        //Get all the reviews grouped by product and zip code;
    public static ArrayList<Review> selectReviewForChart() {


          ArrayList<Review> reviewList = new ArrayList<Review>();
          try {

              getConnection();
              Map<String, Object> dbObjIdMap = new HashMap<String, Object>();
              dbObjIdMap.put("zipCode", "$zipCode");
              System.out.println(dbObjIdMap+"sdsdsddsdsdsdsdsdsdsdsddsdsdsdsdsd");
              dbObjIdMap.put("productName", "$productName");
              DBObject groupFields = new BasicDBObject("_id", new BasicDBObject(dbObjIdMap));
              groupFields.put("count", new BasicDBObject("$sum", 1));
              DBObject group = new BasicDBObject("$group", groupFields);

              DBObject projectFields = new BasicDBObject("_id", 0);
              projectFields.put("zipCode", "$_id");
              projectFields.put("productName", "$productName");
              projectFields.put("reviewCount", "$count");
              DBObject project = new BasicDBObject("$project", projectFields);

              DBObject sort = new BasicDBObject();
              sort.put("reviewCount", -1);

              DBObject orderby = new BasicDBObject();
              orderby = new BasicDBObject("$sort",sort);


              AggregationOutput aggregate = myReviews.aggregate(group, project, orderby);

              for (DBObject result : aggregate.results()) {

                  BasicDBObject obj = (BasicDBObject) result;
                  Object o = com.mongodb.util.JSON.parse(obj.getString("zipCode"));
                  BasicDBObject dbObj = (BasicDBObject) o;
                  Review review = new Review(dbObj.getString("productName"), dbObj.getString("zipCode"),
                          obj.getString("reviewCount"), null);
                  System.out.println(dbObj.getString("productName"));
                  System.out.println(dbObj.getString("reviewCount"));
                 
                  System.out.println(dbObj.getString("zipCode"));
                  reviewList.add(review);
         System.out.println(reviewList.get(0).getProductName()+"po ra pooka");
              }
             System.out.println(reviewList.get(0).getProductName()+"po ra pooka");
              return reviewList;

          }

          catch (

          Exception e) {
              reviewList = null;

              return reviewList;
          }

      }
    
    }