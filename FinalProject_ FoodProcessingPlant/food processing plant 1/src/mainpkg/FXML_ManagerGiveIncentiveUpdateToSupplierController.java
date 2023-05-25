
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_ManagerGiveIncentiveUpdateToSupplierController implements Initializable {

    @FXML
    private TextField toIdLabel;
    @FXML
    private TextField amountLabel;
    @FXML
    private DatePicker date;
    
    private Manager user;
    public void initData(Manager u) {
        user = u;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        user.submitIncentive(toIdLabel.getText(),amountLabel.getText(),date.getValue());
         toIdLabel.clear();
         amountLabel.clear();
         
         
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
          FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerHomeScen.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerHomeScenController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
