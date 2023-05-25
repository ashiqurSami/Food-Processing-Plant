
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class FXML_SupplierCheckPaymentMessageController implements Initializable {

    @FXML
    private TextArea paymentHistoryTextArea;

    /**
     * Initializes the controller class.
     */
    private Supplier user;

    public void initData(Supplier u) {
         user = u;
         paymentHistoryTextArea.setText("");
         ArrayList<PaymentUpdate>pList= user.checkPaymentUpdate(user.getId());
         ArrayList<PaymentUpdate>copy=new ArrayList();
         for(PaymentUpdate i:pList)
         {
             if(user.getId()==Integer.parseInt(i.getToID()))
             {
                 copy.add(i);
             }
         }
         for(PaymentUpdate i:copy)
         {
             paymentHistoryTextArea.appendText(i.toString());
             
         }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          
        // TODO
    }    

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_SupplierHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_SupplierHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
