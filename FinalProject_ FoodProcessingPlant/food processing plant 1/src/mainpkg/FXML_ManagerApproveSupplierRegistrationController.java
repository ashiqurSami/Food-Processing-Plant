
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXML_ManagerApproveSupplierRegistrationController implements Initializable {

    @FXML
    private TableView<NewRawMaterial> tableView;
    @FXML
    private TableColumn<NewRawMaterial, String> idColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> materialNameColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> divisionColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> districtColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> descriptionColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> dateColoumn;
    @FXML
    private TableColumn<NewRawMaterial, String> deliveryDurationColoumn;
     private Manager user;

    public void initData(Manager u) {
        user = u;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        idColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("id"));
        materialNameColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("materialName"));
        divisionColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("division"));
        districtColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("district"));
        descriptionColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("description"));
        dateColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("date"));
        deliveryDurationColoumn.setCellValueFactory(new PropertyValueFactory<NewRawMaterial, String>("durationMonth"));
        
        
       
        ArrayList<NewRawMaterial> p= NewRawMaterial.listOfRegistration();
        for (NewRawMaterial i : p) {
            if (i.isIsCheck() == false) {
                tableView.getItems().add(i);
            }
        }
    }    

    @FXML
    private void approveButtonOnClick(ActionEvent event) throws IOException {
        ObservableList<NewRawMaterial> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (NewRawMaterial p : selectedRows) {
            user.approvedRegistration(p, true, true);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Approved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerApproveSupplierRegistration.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerApproveSupplierRegistrationController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void disapproveButtonOnClick(ActionEvent event) throws IOException {
         ObservableList<NewRawMaterial> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (NewRawMaterial p : selectedRows) {
            user.approvedRegistration(p, false, true);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Disapproved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerApproveSupplierRegistration.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerApproveSupplierRegistrationController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerHomeScen.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerHomeScenController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void detailoedViewButtonOnClick(ActionEvent event) throws IOException {
   
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_DetailoedSupplierRegistrationView.fxml"));
        Parent regViewParent = loader.load();
        Scene regViewScene = new Scene(regViewParent);
        FXML_DetailoedSupplierRegistrationViewController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        Stage window=new Stage(); 
        window.setScene(regViewScene);
        window.show();
    }
    
}
