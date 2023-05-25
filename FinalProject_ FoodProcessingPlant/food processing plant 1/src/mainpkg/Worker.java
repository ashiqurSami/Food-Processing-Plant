
package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Worker extends User
{

    public Worker(String name, String user_type, String email, String password, int id) {
        super(name, user_type, email, password, id);
    }
    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("User.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void giveLeaveApplication(int applicantID, String reason, LocalDate from, LocalDate to, String workStatus,int applicationNo, String applicantName){
        LeaveApplication l = new LeaveApplication(applicantID, reason, from, to, workStatus,applicationNo, applicantName);
        l.addLeaveApplication(false);
    }
    
    public String viewLeaveApplicationStatus(){
        ArrayList<LeaveApplication>l = LeaveApplication.listOLeaveApplication();
        String st = "";
        for(LeaveApplication i: l){
            if(i.getApplicantID() == id){
                st = st+"Application No. : "+i.getApplicationNo()+"\n" +"Reason: "+i.getReason()+"\n"+"From Date: "+i.getFrom()+"\n"+"To Date: "+i.getTo()
                        +"\n";
                if(i.isIsCheck())
                {
                    if(i.isIsApproved())
                    {
                      st=st+"Your Leave application is approved"+"\n \n";  
                }
                    else
                    {
                        st=st+"Your Leave application is rejected"+"\n \n";
                    }
            }
                else
                {
                    st=st+"Your Leave application have not checked yet"+"\n\n";
                }
        }
       
    }
         return st;
    }
    
    public void updateCompanyProductDetails(int productID, String productName, String details, String productPrice){
        PoductDetails p = new PoductDetails(productID, productName, details, productPrice);
        p.addPoductDetails();
    }
     
    public ArrayList<Incentive>viewIncentiveList()
    {
        ArrayList<Incentive>iList=new ArrayList<>();
        iList=Incentive.viewIncentiveList();
        return iList;
    }
    public void updateInventory(String poductName,String total,LocalDate date)
    {
        Inventory i=new Inventory(poductName,Float.parseFloat(total),date);
        i.addtoInventory();
    }
}
