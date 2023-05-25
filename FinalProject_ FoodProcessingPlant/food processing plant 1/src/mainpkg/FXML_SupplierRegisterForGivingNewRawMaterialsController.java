
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_SupplierRegisterForGivingNewRawMaterialsController implements Initializable {

    @FXML
    private TextField materialNameTextField;
    @FXML
    private TextField divisionTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private ComboBox<String> durationMonthComboBox;
    @FXML
    private TextArea descriptionTextArea;
    private Supplier user;
    @FXML
    private DatePicker date;
    @FXML
    private TextField regNoTextField;

    public void initData(Supplier u) {
        user = u;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        durationMonthComboBox.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
         Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        regNoTextField.setText(Integer.toString(rand_int1));
    }    


    @FXML
    private void backButtonOnCLICK(ActionEvent event) throws IOException {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_SupplierHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_SupplierHomeSceneController controller1 = loader1.getController();
                controller1.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) throws IOException {
        
        Random rand = new Random();
        int ran = rand.nextInt(1000);
        user.regForGivingNewMaterials(Integer.toString(user.getId()),materialNameTextField.getText(),divisionTextField.getText(),districtTextField.getText(), durationMonthComboBox.getValue(),descriptionTextArea.getText(),date.getValue(),regNoTextField.getText());
        materialNameTextField.clear();
        divisionTextField.clear();
        districtTextField.clear();
        descriptionTextArea.clear();
        regNoTextField.setText(Integer.toString(ran));
        
     }

    @FXML
    private void viewRegistrationStatusButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_SupplierViewRegistrationStatus.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_SupplierViewRegistrationStatusController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
