
package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Manager extends User implements Serializable {

    public Manager(String name, String user_type, String email, String password, int id) {
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
  
    public void givePaymentUpdate(String toID,LocalDate date,String amount,String message){
        PaymentUpdate pu=new PaymentUpdate(toID,date,amount,message);
        pu.add();
        
    }
    
    public void approvedRegistration(NewRawMaterial p, boolean approve, boolean check){
        ArrayList<NewRawMaterial>pList = NewRawMaterial.listOfRegistration();
        File f = null;
        f = new File("New Raw Material.bin");
        if(f.exists()){
            f.delete();
        }
        for(NewRawMaterial i: pList){
            if(Integer.parseInt(i.getRegNo()) == Integer.parseInt(p.getRegNo())){
                i.setIsApproved(approve);
                i.setIsCheck(check);
            }
            i.register(true);
        }
    }
    public void submitIncentive(String id,String amount,LocalDate date)
    {
        Incentive in=new Incentive(Integer.parseInt(id),Float.parseFloat(amount),date);
        in.addIncentive();
    }
    
    public void replyOnIncreasingTimeForDelivery(SupplierIncreasingTime p){
        ArrayList<SupplierIncreasingTime>list = SupplierIncreasingTime.listOfSupplierIncreasingTime();
        File f = null;
        f = new File("Supplier Increasing Time.bin");
        if(f.exists()){
            f.delete();
        }
        for(SupplierIncreasingTime i: list){
            if(p.getsNo()==i.getsNo()){
                p.setIsCheck(true);
                p.addSupplierIncreasingTime();
            }
            i.addSupplierIncreasingTime();
        }
    }
}
