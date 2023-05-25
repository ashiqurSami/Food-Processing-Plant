
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_SupplierContactForUrgentIssueController implements Initializable {
     
    @FXML
    private TextField idTextField;
    @FXML
    private TextArea problemTextArea;
    @FXML
    private TextField problemNoTextField;
    private Supplier user;

    public void initData(Supplier u) {
        user = u;
        idTextField.setText(Integer.toString(user.getId()));
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        problemNoTextField.setText(Integer.toString(rand_int1));
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        user.createProblem(user.getId(),problemTextArea.getText(),problemNoTextField.getText());
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        problemNoTextField.setText(Integer.toString(rand_int1));
        problemTextArea.clear();
        
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
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
    private void viewSubmittedProblemAnswerButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_SupplierViewSubmittedProblemAnswer.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_SupplierViewSubmittedProblemAnswerController controller1 = loader1.getController();
                controller1.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
    }
    
}
