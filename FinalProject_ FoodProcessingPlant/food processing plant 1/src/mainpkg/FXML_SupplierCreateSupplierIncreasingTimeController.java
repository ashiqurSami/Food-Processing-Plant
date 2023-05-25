
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_SupplierCreateSupplierIncreasingTimeController implements Initializable {

    @FXML
    private TextField toIdField;
    @FXML
    private DatePicker prevDate;
    @FXML
    private DatePicker newDate;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private TextArea viewResponsTextArea;
    private Supplier user;

    public void initData(Supplier u) {
        user = u;
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickBackButton(ActionEvent event) throws IOException {
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
    private void onClickSendButton(ActionEvent event) {
        Random rand = new Random();
        user.requestForIncreasingDeliveryTime(
                user.getId(), 
                Integer.parseInt(toIdField.getText()),
                rand.nextInt(1000),
                prevDate.getValue(),
                newDate.getValue(),
                reasonTextArea.getText(),
                ""
        );
               toIdField.setText(null);
                prevDate.setValue(null);
                newDate.setValue(null);
                reasonTextArea.setText(null);
    }

    @FXML
    private void onClickViewButto(ActionEvent event) {
        viewResponsTextArea.setText(user.viewManagerResponse());
    }
    
}
