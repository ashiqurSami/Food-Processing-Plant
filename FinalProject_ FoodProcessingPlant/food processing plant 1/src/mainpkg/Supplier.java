
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Supplier extends User implements Serializable{

    public Supplier(String name, String user_type, String email, String password, int id) {
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
    public void regForGivingNewMaterials(String id,String materialName,String division,String district,String durationMonth,String description,LocalDate date,String regNo)
    {
        NewRawMaterial raw=new NewRawMaterial(id,materialName,division,district,durationMonth,description,date,regNo);
        raw.register(false);
    }
    public  ArrayList<PaymentUpdate> checkPaymentUpdate(int id)
    {
        
        String Id=Integer.toString(id);
        ArrayList<PaymentUpdate> p=new ArrayList<>();
        ArrayList<PaymentUpdate> r=new ArrayList<>();
        p=PaymentUpdate.listOfGivenPayment();
        
        for(PaymentUpdate i:p)
        {   
            
            if(i.getToID().equals(Id))
            {
                r.add(i);
                
            }
        }
        return r;
    }
    public ArrayList <NewRawMaterial> checkStatus(int id)
    {
         ArrayList<NewRawMaterial> p=new ArrayList<>();
        ArrayList<NewRawMaterial> r=new ArrayList<>();
        p=NewRawMaterial.listOfRegistration();
         for(NewRawMaterial i:p)
         {
             if(Integer.parseInt(i.getId())==id)
             {
                 r.add(i);
             }
         }
         return r;
    }
    
    public void createProblem(int id,String problem,String problemNo )
    {  
        
        
        Problem p=new Problem(id,problem,Integer.parseInt(problemNo));
        p.addProblem(true);
    }

    public ArrayList<Problem> seeAnswer()
    {
       ArrayList<Problem>pList=Problem.problemList();
       return pList;
    }
    
    public void GiveBroucher(String id,String materialName,String quantity,String totalCost,LocalDate date)
    
    {
       
        CostReceipt cr=new CostReceipt(materialName,Float.parseFloat(quantity),Float.parseFloat(totalCost),Integer.parseInt(id),date);
        cr.addCostReceipt();
    }
    
    public String viewManagerResponse(){
        ArrayList<SupplierIncreasingTime> list = SupplierIncreasingTime.listOfSupplierIncreasingTime();
        String response = "";
        for(SupplierIncreasingTime i: list){
            if(id == i.getFromID() && !(i.getAnswer().equals(""))){    
                response = response+i.toString();
            }
        }
        return response;
    }
    
    public void requestForIncreasingDeliveryTime(int fromID, int toID, int sNo, LocalDate previousGivenDate, LocalDate newGivenDate, String reason, String answer){
        SupplierIncreasingTime s = new SupplierIncreasingTime(fromID, toID, sNo, previousGivenDate, newGivenDate,reason,answer);
        s.addSupplierIncreasingTime();
    }
  
}
