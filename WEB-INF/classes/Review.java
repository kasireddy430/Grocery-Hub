import java.io.IOException;
import java.io.*;

public class Review implements Serializable {
    private String Name;
    private String user;
    private String Id;
    private String date;
    private String rate;
    private String feedback;
    private String zipCode;


    public Review(String Name, String user, String Id, String date,
                  String rate, String feedback, String zipCode) {
        this.Name = Name;
        this.user= user;
        this.rate = rate;
        this.Id= Id;
        this.date = date;
        this.feedback = feedback;
        this.zipCode = zipCode;
    }

    public Review(String Name, String zipCode, String rate, String feedback) {
        this.Name = Name;
        this.zipCode = zipCode;
        this.rate = rate;
        this.feedback =feedback;
    }
    public String getProductName() {
        return Name;
    }

    public String getName() {
        return user;
    }

    public void setProductName(String Name) {
        this.Name = Name;
    }

    public String getRating() {
        return rate;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setName(String user) {
        this.user = user;
    }

    public void setRating(String rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProductId() {
        return Id;
    }

    public void setProductId(String Id) {
        this.Id = Id;
    }

    public String getzipCode() {
        return zipCode;
    }

    public void setzipCode(String zipCode) {
        this.zipCode = zipCode;
    }

}
