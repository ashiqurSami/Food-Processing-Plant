
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


public class FXML_WorkerGiveLeaveApplicationController implements Initializable {

    private Worker user;
    @FXML
    private ComboBox<String> workStatusCombo;
    @FXML
    private TextField appNoTextField;
    @FXML
    private TextField appNameTextField;

    public void initData(Worker u) {
        user = u;
        workStatusCombo.setValue(user.getUser_type());
        appIDTextField.setText(Integer.toString(user.getId()));
        appNameTextField.setText(user.getName());
    }

    @FXML
    private TextField appIDTextField;
    @FXML
    private TextArea reasonTextArea;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    @FXML
    private TextArea viewApplicationTextArea;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        workStatusCombo.getItems().addAll("Head","Manager","Suppier","Customer","Worker","Admin");
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        appNoTextField.setText(Integer.toString(rand_int1));
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_WorkerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_WorkerHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        user.giveLeaveApplication(
            Integer.parseInt(appIDTextField.getText()),
            reasonTextArea.getText(),
            fromDate.getValue(),
            toDate.getValue(),
            workStatusCombo.getValue(),
            Integer.parseInt(appNoTextField.getText()),
            appNameTextField.getText()
        );
        reasonTextArea.setText(null);
        fromDate.setValue(null);
        toDate.setValue(null);
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        appNoTextField.setText(Integer.toString(rand_int1));
    }

    @FXML
    private void onClickViewApplicationButton(ActionEvent event) {
        viewApplicationTextArea.setText(user.viewLeaveApplicationStatus()+"Completed!!!");
    }

}
