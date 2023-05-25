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

public class LeaveApplication implements Serializable {
    private int applicantID;
    private int applicationNo;
    private String applicantName;
    private String reason;
    private LocalDate from,to;
    private String workStatus;
    private boolean isApproved;
    private boolean isCheck = false;

    public LeaveApplication(int applicantID, String reason, LocalDate from, LocalDate to, String workStatus,
        int applicationNo, String applicantName) {
        this.applicantID = applicantID;
        this.reason = reason;
        this.from = from;
        this.to = to;
        this.workStatus = workStatus;
        this.applicantName = applicantName;
        this.applicationNo = applicationNo;
    }
    
    public void addLeaveApplication(boolean x) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("Leave Application.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);
            if(x==false)
            {
                
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Submitted");
            a.showAndWait();
            }

        } catch (IOException ex) {
            Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(LeaveApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<LeaveApplication> listOLeaveApplication(){
        ArrayList<LeaveApplication>uList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Leave Application.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            LeaveApplication u;
            try{
                while(true){
                    u = (LeaveApplication)ois.readObject();
                    uList.add(u);
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch                 
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }    
        return uList;
    }

    public int getApplicantID() {
        return applicantID;
    }

    public String getReason() {
        return reason;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public boolean isIsCheck() {
        return isCheck;
    }

    public int getApplicationNo() {
        return applicationNo;
    }

    public String getApplicantName() {
        return applicantName;
    }
    
}

