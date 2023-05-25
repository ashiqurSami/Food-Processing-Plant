
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_AdminCreateUserController implements Initializable {
    private Admin user;
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passField;
    @FXML
    private TextArea outputTextArea;
    @FXML
    private ComboBox<String> userTypeField;
    public void initData(Admin u){
        user = u;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeField.getItems().addAll("Head","Manager","Supplier","Customer","Worker","Admin");
    }    

    @FXML
    private void clickOnReadButton(ActionEvent event) {
        outputTextArea.setText("");
        ArrayList<User>u = UserList.listOfUser();
        if(u != null){
            for(User i: u){
                outputTextArea.appendText(i.toString()+"\n");
            }
        }
        outputTextArea.appendText("All objects are loaded successfully...\n");
    }

    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        
        Admin.createUser(nameField.getText(),
                    userTypeField.getValue().toString(),
                    emailField.getText(),
                    passField.getText(),
                    Integer.parseInt(idField.getText())
        );                  
        nameField.setText(null);
        idField.setText(null);
        emailField.setText(null);
        passField.setText(null);
        userTypeField.setValue(null);
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_AdminHomeScen.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_AdminHomeScenController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
