
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

    public class Inventory implements Serializable {
    private String poductName;
    private float manufactureUnit;
    private LocalDate date;

    public Inventory(String poductName, float manufactureUnit, LocalDate date) {
        this.poductName = poductName;
        this.manufactureUnit = manufactureUnit;
        this.date = date;
    }

    public String getPoductName() {
        return poductName;
    }

    public void setPoductName(String poductName) {
        this.poductName = poductName;
    }

    public float getManufactureUnit() {
        return manufactureUnit;
    }

    public void setManufactureUnit(float manufactureUnit) {
        this.manufactureUnit = manufactureUnit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void addtoInventory()
    {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Inventory record.bin");
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
            a.setContentText("Successfully added");
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
  public static ArrayList<Inventory>  listOfInventory()
  {
      ArrayList<Inventory> nList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Inventory record.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Inventory m;
            try {
                while (true) {
                    m = (Inventory) ois.readObject();
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
