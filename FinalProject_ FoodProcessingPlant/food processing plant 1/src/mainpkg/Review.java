
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class Review implements Serializable{
    private String ProductName;
    private String text,cusName;
    private int satisdactionRate, budgetRate, cusID;    

    public Review(String ProductName, String text, String cusName, int satisdactionRate, int budgetRate, int cusID) {
        this.ProductName = ProductName;
        this.text = text;
        this.cusName = cusName;
        this.satisdactionRate = satisdactionRate;
        this.budgetRate = budgetRate;
        this.cusID = cusID;
    }
    
    public void addReview() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Review.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Review Saved");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Review> listOfReview() {
        ArrayList<Review> mList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Review.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Review m;
            try {
                while (true) {
                    m = (Review) ois.readObject();
                    mList.add(m);
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch                 
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return mList;
    }

    @Override
    public String toString() {
        return "Customer ID: " + cusID +"\n" + "Custoemr Name: " + cusName +"\n"  + "Product Name:" + ProductName +"\n"+ "Review: " + text + "\n"+ "Satisfaction Rate: " + satisdactionRate +"\n"+ "Budget Rate: " + budgetRate+"\n\n";
    }

    public String getProductName() {
        return ProductName;
    }

    public String getText() {
        return text;
    }

    public String getCusName() {
        return cusName;
    }

    public int getSatisdactionRate() {
        return satisdactionRate;
    }

    public int getBudgetRate() {
        return budgetRate;
    }

    public int getCusID() {
        return cusID;
    }
    
    
}
