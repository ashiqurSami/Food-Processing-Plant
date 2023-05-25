
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

//supplier
public class SupplierIncreasingTime implements Serializable {
    
    private int fromID,toID, sNo;
    private LocalDate previousGivenDate;
    private LocalDate newGivenDate;
    private String reason;
    private String answer;
    private boolean isCheck = false;

    public SupplierIncreasingTime(int fromID, int toID, int sNo, LocalDate previousGivenDate, LocalDate newGivenDate, String reason,String answer) {
        this.fromID = fromID;
        this.toID = toID;
        this.sNo = sNo;
        this.previousGivenDate = previousGivenDate;
        this.newGivenDate = newGivenDate;
        this.reason = reason;
        this.answer = answer;
    }

    
    
    
    public void addSupplierIncreasingTime() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Supplier Increasing Time.bin");
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
            a.setContentText("Successfully Submitted");
            a.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(SupplierIncreasingTime.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(SupplierIncreasingTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public String toString() {
        return "fromID=" + fromID +"\n"+ ", toID=" + toID+"\n" + ", sNo=" + sNo+"\n" + ", previousGivenDate=" + previousGivenDate+"\n" + ", newGivenDate=" + newGivenDate +"\n"+ ", reason=" + reason +"\n"+ ", answer=" + answer +"\n"+ ", isCheck=" + isCheck +"\n"+"\n";
    }

    public static ArrayList<SupplierIncreasingTime> listOfSupplierIncreasingTime() {
        ArrayList<SupplierIncreasingTime> mList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Supplier Increasing Time.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            SupplierIncreasingTime m;
            try {
                while (true) {
                    m = (SupplierIncreasingTime) ois.readObject();
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
    
    
    
    public int getFromID() {
        return fromID;
    }

    public int getToID() {
        return toID;
    }

    public int getsNo() {
        return sNo;
    }

    public LocalDate getPreviousGivenDate() {
        return previousGivenDate;
    }

    public LocalDate getNewGivenDate() {
        return newGivenDate;
    }

    public String getReason() {
        return reason;
    }

    public String getAnswer() {
        return answer;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public boolean isIsCheck() {
        return isCheck;
    }
}
