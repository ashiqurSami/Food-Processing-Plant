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
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;

public class Problem implements  Serializable{
    private int fromID;
    private String problemText;
    private String problemAnswer="";
    private int problemNo;
    private boolean isCheck=false;

    public Problem(int fromID, String problemText, int problemNo) {
        this.fromID = fromID;
        this.problemText = problemText;
        this.problemNo = problemNo;
    }
    
    public void setFromID(int fromID) {
        this.fromID = fromID;
    }

    public void setProblemText(String problemText) {
        this.problemText = problemText;
    }

    public String getProblemAnswer() {
        return problemAnswer;
    }

    public void setProblemAnswer(String problemAnswer) {
        this.problemAnswer = problemAnswer;
    }

    

    public void setProblemNo(int problemNo) {
        this.problemNo = problemNo;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public int getFromID() {
        return fromID;
    }

    public String getProblemText() {
        return problemText;
    }

    

    public int getProblemNo() {
        return problemNo;
    }

    public boolean isIsCheck() {
        return isCheck;
    }

    @Override
    public String toString() {
        return "Problem{" + "fromID=" + fromID + ", problemText=" + problemText + ", problemAnswer=" + problemAnswer + ", problemNo=" + problemNo + "\n"+'}';
    }
    
    
   
    public void addProblem(boolean x)
    {
         File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Supplier Problem.bin");
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
                a.setContentText("Submitted");
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

   
    
    

    public static ArrayList<Problem> problemList()
    {   
        
         ArrayList<Problem>rList = new ArrayList<>();
        
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("Supplier Problem.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
           Problem u;
            System.out.println("ekhane");
            try{
                while(true){
                    u = (Problem)ois.readObject();
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
       
        for(Problem i:rList)
        {
            i.toString();
        }
        return rList;
        
    }
    public void receivedAnswer(String text)
    {

        ArrayList<Problem> pList = problemList();
        File f = null;
        f = new File("Supplier Problem.bin");
        if (f.exists()) {
            f.delete();
        }
        for (Problem i : pList) {
            if (i.getProblemNo() == problemNo) {
                i.isCheck = true;
                i.problemAnswer = text;
            }
            i.addProblem(true);
        }
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Information Alert");
        a.setHeaderText("Information");
        a.setContentText("Sent");
        a.showAndWait();
    }
    
    
}