import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.util.*;

public class ProductRecommenderUtility{

	static Connection conn = null;
    static String message;

	public static String getConnection()
	{

		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
			message="Successfull";
			return message;
		}
		catch(SQLException e)
		{
			 message="unsuccessful";
		     return message;
		}
		catch(Exception e)
		{
			 message="unsuccessful";
		     return message;
		}
	}

	public HashMap<String,String> readOutputFile(){


		String TOMCAT_HOME = System.getProperty("catalina.home");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
		try {

            br = new BufferedReader(new FileReader(new File(TOMCAT_HOME+"\\webapps\\project\\output.csv")));
            System.out.println("productrecommender"+br);
            while ((line = br.readLine()) != null) {


                // use comma as separator
                String[] prod_recm = line.split(cvsSplitBy,2);
				prodRecmMap.put(prod_recm[0],prod_recm[1]);
                System.out.println(prodRecmMap);
            }

		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
		}
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjj"+prodRecmMap);

		return prodRecmMap;
	}

	public static Product getProduct(String product){
		System.out.println(product+"name of the product");
		Product prodObj = new Product();
		try
		{
			String msg = getConnection();
			String selectProd="select * from  groceryhub where product_name=?";
			PreparedStatement pst = conn.prepareStatement(selectProd);
			pst.setString(1,product);
			ResultSet rs = pst.executeQuery();
            System.out.println(rs);
			while(rs.next())
			{
                System.out.println(rs.getString("product_name"));
				prodObj = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getString("product_description"),rs.getDouble("product_currentprice"),rs.getInt("product_discount"),rs.getDouble("product_actualprice"),rs.getString("product_category"),rs.getString("product_image"),rs.getString("product_manufacturer"),rs.getInt("inventory"),rs.getString("store_zipcode"),rs.getInt("rating"),rs.getString("product_condition"));
			}
			rs.close();
			pst.close();
			conn.close();
		}
		catch(Exception e)
		{
			System.out.println(e+"exception");
		}
		return prodObj;
	}
}
