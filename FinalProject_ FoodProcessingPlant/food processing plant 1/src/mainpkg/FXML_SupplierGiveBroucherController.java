
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


public class FXML_SupplierGiveBroucherController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private TextField materialNameTextField;
    @FXML
    private TextField quantityTextField;
    @FXML
    private TextField totalCostTextField;
     
    private Supplier user;
    @FXML
    private DatePicker date;
    public void initData(Supplier u) {
        user = u;
        idTextField.setText(Integer.toString(user.getId()));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        user.GiveBroucher(idTextField.getText(),materialNameTextField.getText(),quantityTextField.getText(),totalCostTextField.getText(),date.getValue());
        materialNameTextField.clear();
        quantityTextField.clear();
        totalCostTextField.clear();
        
    }

    @FXML
    private void backButtonONClick(ActionEvent event) throws IOException {
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
