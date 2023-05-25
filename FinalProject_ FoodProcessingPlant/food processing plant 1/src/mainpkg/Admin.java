package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

public class Admin extends User implements Serializable {
    
    public Admin(){
        
    }
    public Admin(String name, String user_type, String email, String password, int id) {
        super(name, user_type, email, password, id);
    }

    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("User.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

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

    public static void createUser(String name,String userType, String email, String pass, int id ) {
        if (userType == "Head") {
            Head h = new Head(name, userType,email, pass, id);
            h.addUser();
        }
        else if (userType == "Manager") {
            Manager h = new Manager(name, userType,email, pass, id);
            h.addUser();
        }
        else if (userType == "Admin") {
            Admin h = new Admin(name, userType,email, pass, id);
            h.addUser();
        }
        else if (userType == "Supplier") {
            System.out.println("yesssssss");
            Supplier h = new Supplier(name, userType,email, pass, id);
            h.addUser();
        }
        else if (userType == "Customer") {
            Customer h = new Customer(name, userType,email, pass, id);
            h.addUser();
        }
        else if (userType == "Worker") {
            Worker h = new Worker(name, userType,email, pass, id);
            h.addUser();
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Account Created");
            a.showAndWait();
    }
    
    public void updateCompanyDetails(String details){
        File f = null;
        f = new File("Company Details.bin");
        if(f.exists()){
            f.delete();
        }
        CompanyDetails c = new CompanyDetails(details);
        c.addCompanyDetails();
    }
    public void setFaqAns(String no,String ans)
    {
        Query q=new Query(Integer.parseInt(no),ans);
        q.setFaqAns();
        
    }
}
