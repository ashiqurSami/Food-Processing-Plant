
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

public class DistributorApplication implements Serializable
{
    private int applicantID;
    private String applicantName;
    private int applicationID;
    private String division;
    private String district;
    private String remarks;
    private String phone;
    private Boolean isApproved=false;
    private Boolean isChecked=false;

    public DistributorApplication(int applicantID, String applicantName, int applicationID, String division, String district, String remarks, String phone) {
        this.applicantID = applicantID;
        this.applicantName = applicantName;
        this.applicationID = applicationID;
        this.division = division;
        this.district = district;
        this.remarks = remarks;
        this.phone = phone;
    }
    
    public void addDistributor(boolean x)
    {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Distributor List.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            
            oos.writeObject(this);
            if(x==false)
            {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Successfully Submitted");
            a.showAndWait();
            }

        } catch (IOException ex) {
            Logger.getLogger(DistributorApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DistributorApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<DistributorApplication> listOfDistributorApplication() {
        ArrayList<DistributorApplication> mList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Distributor List.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            DistributorApplication m;
            try {
                while (true) {
                    m = (DistributorApplication) ois.readObject();
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

    public int getApplicantID() {
        return applicantID;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public String getDivision() {
        return division;
    }

    public String getDistrict() {
        return district;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsApproved() {
        return isApproved;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setApplicantID(int applicantID) {
        this.applicantID = applicantID;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsApproved(Boolean isApproved) {
        this.isApproved = isApproved;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
        String st="";
        st=st+ "applicantID=" + applicantID + "\napplicantName=" + applicantName + "\napplicationID=" + applicationID + "\ndivision=" + division + "\ndistrict=" + district + "\nDescription=" + remarks + "\nphone=" + phone+"\n";
        if(isChecked)
        {
            if(isApproved)
            {
                st=st+"Your Applicaton is approved \n \n";
            }
            else
            {
                st=st+"Your Applicaton is rejected \n \n";
            
            }
        }
        else
        {
            st=st+"Your Applicaton have not checked yet \n \n";
            
        }
        return st;
    }
    
    
}
