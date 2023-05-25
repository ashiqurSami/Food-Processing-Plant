/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_CustomerApplyForDistributorController implements Initializable {

    private Customer user;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField districtTextField;
    @FXML
    private TextField divisionTextField;
    @FXML
    private TextArea remarksTextArea;
    @FXML
    private TextField phoneNumberTextField;

    public void initData(Customer u) {
        user = u;
        idTextField.setText(Integer.toString(user.getId()));
        nameTextField.setText(user.getName());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void submitButtonONClick(ActionEvent event) {
        String phn = phoneNumberTextField.getText();
        user.applyForDistributor(user.getId(), user.getName(), divisionTextField.getText(), districtTextField.getText(), remarksTextArea.getText(), phn);
        
        districtTextField.setText(null);
        divisionTextField.setText(null);
        remarksTextArea.setText(null);
        phoneNumberTextField.setText(null);
    }

    @FXML
    private void BackButtonONClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_CustomerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_CustomerHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void viewSubmittedApplicationOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_CustomerViewSubmittedApplication.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_CustomerViewSubmittedApplicationController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
        
       
    }

}
