
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_WorkerUpdateInventoryController implements Initializable {

    @FXML
    private ComboBox<String> productNameComboBox;
    @FXML
    private DatePicker date;
    @FXML
    private TextField totalManufactureUnitTextArea;

    /**
     * Initializes the controller class.
     */
    private Worker user;
    public void initData(Worker u)
    {
        user=u;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<PoductDetails>pList= PoductDetails.listOfPoductDetails();
        for(PoductDetails i:pList)
        {
            productNameComboBox.getItems().add(i.getProductName());
        }
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        user.updateInventory(productNameComboBox.getValue(),totalManufactureUnitTextArea.getText(),date.getValue());
        totalManufactureUnitTextArea.clear();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_WorkerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_WorkerHomeSceneController controller1 = loader1.getController();
                controller1.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
    }
    
}
