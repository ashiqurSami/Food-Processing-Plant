 package mainpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer extends User implements Serializable {

    public Customer(String name, String user_type, String email, String password, int id) {
        super(name, user_type, email, password, id);
    }

    public String getName() {
        return name;
    }

    public String getUser_type() {
        return user_type;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
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

    public void applyForDistributor(int id, String name, String division, String district, String remarks, String phone) {
        Random rand = new Random();
        int r = rand.nextInt(100000);
        DistributorApplication da = new DistributorApplication(id, name, r, division, district, remarks, phone);
        da.addDistributor(false);
    }

    public void giveReview(String ProductName, String text, String cusName, int satisdactionRate, int budgetRate, int cusID) {
        Review r = new Review(ProductName, text, cusName, satisdactionRate, budgetRate, cusID);
        r.addReview();
    }

    public String answer(int i) {
        ArrayList<Query> qList = new ArrayList<>();
        qList = Query.getAnswerList();
        String s = new String();
        for (Query j : qList) {
            if (j.getNo() == i) {
                s = j.getAnswer();

            }
        }
        return s;

    }

    public String viewApplication(int id) {
        ArrayList<DistributorApplication> l = DistributorApplication.listOfDistributorApplication();
      String st="";
        System.out.println("123");
        for (DistributorApplication i : l) {
            System.out.println("789");
            if (i.getApplicantID() == id) {
                System.out.println("hello peter");
               st=st+i.toString()+"\n\n";
            }
        }
         return st;
    }
   
}
