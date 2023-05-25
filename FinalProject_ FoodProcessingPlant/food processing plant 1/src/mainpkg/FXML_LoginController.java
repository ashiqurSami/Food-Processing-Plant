
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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_LoginController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox<String> comboUserType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboUserType.getItems().addAll("Head","Manager","Supplier","Customer","Worker","Admin");
        ArrayList<User>uList = UserList.listOfUser();
        for(User i : uList){
            System.out.println(i.toString());
        }
    }    

    @FXML
    private void onClickLoginButton(ActionEvent event) throws IOException {
        User u = User.login(Integer.parseInt(idField.getText()),passwordField.getText(),comboUserType.getValue().toString());
        if(u == null){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error Alert");
            a.setHeaderText("Invalid Id or Password");
            a.setContentText("Oops! Something went wrong...");
            a.showAndWait();
        }
        else{
            if(u instanceof Manager){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_ManagerHomeScen.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_ManagerHomeScenController controller1 = loader1.getController();
                controller1.initData((Manager)u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } 
            else if(u instanceof Head){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_HeadHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_HeadHomeSceneController controller1 = loader1.getController();
                controller1.initData((Head)u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } 
            else if(u instanceof Customer){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_CustomerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_CustomerHomeSceneController controller1 = loader1.getController();
                controller1.initData((Customer)u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } 
            else if(u instanceof Worker){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_WorkerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_WorkerHomeSceneController controller1 = loader1.getController();
                controller1.initData((Worker)u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } 
            else if(u instanceof Supplier){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_SupplierHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_SupplierHomeSceneController controller1 = loader1.getController();
                controller1.initData((Supplier)u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } 
            else if(u instanceof Admin){
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_AdminHomeScen.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_AdminHomeScenController controller1 = loader1.getController();
                controller1.initData((Admin) u);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            }
        }
                
        
    }
    
}
