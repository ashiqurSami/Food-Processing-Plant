
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_SupplierViewSubmittedProblemAnswerController implements Initializable {

    @FXML
    private TextArea problemTextArea;
    @FXML
    private TextArea messageTextArea;
    private Supplier user;
    private TextField problemNoLabel;
    @FXML
    private Label updateLabel;
    @FXML
    private ComboBox<String> problemNoComboBox;
     public void initData(Supplier u) {
        user = u;
         ArrayList<Problem>pList= user.seeAnswer();
       ArrayList<Problem>copy=new ArrayList<>();
       for(Problem i:pList)
       {
           if(i.getFromID()==user.getId())
           {
               copy.add(i);
               problemNoComboBox.getItems().add(Integer.toString(i.getProblemNo()));
           }
       }
    }
    
        
@Override
 public void initialize(URL url, ResourceBundle rb) {
      
    }    

    @FXML
    private void backButtonONAction(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_SupplierContactForUrgentIssue.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_SupplierContactForUrgentIssueController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

   
    @FXML
    private void comboBoxOnAction(ActionEvent event) {
        ArrayList<Problem>pList= user.seeAnswer();
       ArrayList<Problem>copy=new ArrayList<>();
       for(Problem i:pList)
       {
           if(i.getFromID()==user.getId())
           {
               copy.add(i);
           }
       }
       for(Problem i:copy)
       {    
            problemTextArea.clear();
           messageTextArea.clear(); 
           if(i.getProblemNo()==Integer.parseInt(problemNoComboBox.getValue()))
           {
               if(i.isIsCheck())
               {
                   problemTextArea.setText(i.getProblemText());
                   messageTextArea.setText(i.getProblemAnswer());
                   
               }
               else
               {   
                   problemTextArea.setText(i.getProblemText());
                   updateLabel.setText("Your Problem Have not checked yet");
               }
                  
           }
           else
           {
               updateLabel.setText("Problem No Is Incorrect");
               
           }
         
       }
    }
    
}
