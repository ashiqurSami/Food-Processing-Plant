
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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class FXML_SupplierViewRegistrationStatusController implements Initializable {

    @FXML
    private TextArea viewTextArea;

    /**
     * Initializes the controller class.
     */
    private Supplier user;
     public void initData(Supplier u) {
        user = u;
       ArrayList<NewRawMaterial> raw= user.checkStatus(user.getId());
       ArrayList<NewRawMaterial> copy=new ArrayList<>();
       
       if(raw==null)
       {
           viewTextArea.setText("Your Didn't Registered"+"\n \n");
       }
       else
       {
           
           for (NewRawMaterial i : raw) {

               viewTextArea.appendText("Reg NO "+i.getRegNo() + "\n");
               if (i.isIsCheck()) {
                   if (i.isIsApproved()) {
                       viewTextArea.appendText("Your Registration is Confirmed" + "\n \n");
                   } else {
                       viewTextArea.appendText("Your Registration is rejected" + "\n \n");
                   }
               } else {
                   viewTextArea.appendText("Your Registration Application Haven't Checked Yet" + "\n \n");
               }

           }
       }
      
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_SupplierRegisterForGivingNewRawMaterials.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_SupplierRegisterForGivingNewRawMaterialsController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
        
    }
    
}
