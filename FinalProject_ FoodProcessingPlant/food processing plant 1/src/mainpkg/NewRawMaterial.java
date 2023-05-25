/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author USER
 */
public class NewRawMaterial implements Serializable{
   private String id, materialName,division,district,durationMonth,description;
   private LocalDate date;
   private boolean isApproved=false;
   private boolean isCheck = false;
   private String regNo;

    public NewRawMaterial(String id, String materialName, String division, String district, String durationMonth, String description, LocalDate date, String regNo) {
        this.id = id;
        this.materialName = materialName;
        this.division = division;
        this.district = district;
        this.durationMonth = durationMonth;
        this.description = description;
        this.date = date;
        this.regNo = regNo;
    }

    public String getId() {
        return id;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getDivision() {
        return division;
    }

    public String getDistrict() {
        return district;
    }

    public String getDurationMonth() {
        return durationMonth;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getRegNo() {
        return regNo;
    }

    

    
    

    public boolean isIsApproved() {
        return isApproved;
    }

    public boolean isIsCheck() {
        return isCheck;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setDurationMonth(String durationMonth) {
        this.durationMonth = durationMonth;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public void setregNo(String regNo) {
        this.regNo = regNo;
    }

   
   public void register(boolean x)
   {
       File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("New Raw Material.bin");
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
            a.setContentText("Registration Completed");
            a.showAndWait();
            }
              

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
   public static ArrayList<NewRawMaterial> listOfRegistration(){
        ArrayList<NewRawMaterial>rList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("New Raw Material.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
           NewRawMaterial u;
            try{
                while(true){
                    u = (NewRawMaterial)ois.readObject();
                    rList.add(u);
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
        return rList;
    }
   
   }
    

