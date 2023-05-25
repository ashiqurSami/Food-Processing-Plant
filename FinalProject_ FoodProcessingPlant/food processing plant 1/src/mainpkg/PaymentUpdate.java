package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class PaymentUpdate implements Serializable{
    private  String toID;
    private LocalDate date;
    private String amount;
    private String message;

    public PaymentUpdate() {
    }
    
    
    public PaymentUpdate(String toID, LocalDate date, String amount, String message) {
        this.toID = toID;
        this.date = date;
        this.amount = amount;
        this.message = message;
    }

    public String getToID() {
        return toID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PaymentUpdate: \n" + "ID=" + toID + "\nDate=" + date + "\nAmount=" + amount + "\nMessage=" + message + "\n \n";
    }
    
    public void add()
    {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Supplier Payment Update.bin");
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
            a.setContentText("Submitted");
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
    public static ArrayList<PaymentUpdate> listOfGivenPayment() {
        ArrayList<PaymentUpdate> nList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Supplier Payment Update.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            PaymentUpdate m;
            try {
                while (true) {
                    m = (PaymentUpdate) ois.readObject();
                    nList.add(m);
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
        return nList;
    }
    
}    
