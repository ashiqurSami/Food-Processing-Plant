
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

public class CompanyDetails implements Serializable{
    private String details;

    public CompanyDetails(String details) {
        this.details = details;
    }
    
    public void addCompanyDetails() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Company Details.bin");
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
            Logger.getLogger(CompanyDetails.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(CompanyDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<CompanyDetails> listOfCompanyDetails() {
        ArrayList<CompanyDetails> mList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Company Details.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            CompanyDetails m;
            try {
                while (true) {
                    m = (CompanyDetails) ois.readObject();
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
        return "CompanyDetails{" + "details=" + details + '}';
    }

   
    
    
}
