
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

public class PoductDetails implements Serializable{
    private int productID;
    private String productName;
    private String details;
    private String productPrice;

    public PoductDetails(int productID, String productName, String details, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.details = details;
        this.productPrice = productPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
    
    
    public void addPoductDetails() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Product.bin");
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
            a.setContentText("Updated");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(PoductDetails.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(PoductDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<PoductDetails> listOfPoductDetails() {
        ArrayList<PoductDetails> mList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Product.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            PoductDetails m;
            try {
                while (true) {
                    m = (PoductDetails) ois.readObject();
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
        return "Product ID: " + productID + "\n" + "Product Name: " + productName + "\n" + "Details: " + details + "\n" + "Product Price: " + productPrice + "\n\n";
    }
    
}
