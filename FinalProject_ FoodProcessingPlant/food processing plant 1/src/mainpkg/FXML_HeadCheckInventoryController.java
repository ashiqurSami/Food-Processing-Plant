
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXML_HeadCheckInventoryController implements Initializable {

    @FXML
    private TableView<Inventory> tableView;
    @FXML
    private TableColumn<Inventory,String> productNameColoumn;
    @FXML
    private TableColumn<Inventory,String> totalManufacturedUnitColoumn;
    @FXML
    private TableColumn<Inventory,String> dateColoumn;
     private Head user;
    @FXML
    private DatePicker fromDate;
    @FXML
    private DatePicker toDate;
    public void initData(Head u){
        user = u;
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }    

    @FXML
    private void viewChartButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML_HeadViewChart.fxml"));
                Parent homeScene1 = loader.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_HeadViewChartController controller = loader.getController();
                controller.initData(user);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(homepage1);
                window.show();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML_HeadHomeScene.fxml"));
                Parent homeScene1 = loader.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_HeadHomeSceneController controller = loader.getController();
                controller.initData(user);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(homepage1);
                window.show();
        
    }

    @FXML
    private void OKButtonOnClick(ActionEvent event) {
         
         tableView.getItems().clear();
         productNameColoumn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("poductName"));
         totalManufacturedUnitColoumn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("manufactureUnit"));
         dateColoumn.setCellValueFactory(new PropertyValueFactory<Inventory, String>("date"));
       
        
       
        ArrayList<Inventory> u = Inventory.listOfInventory();
        for (Inventory i : u) {
                 boolean isbefore=i.getDate().isBefore(toDate.getValue());
                 boolean isafter=i.getDate().isAfter(fromDate.getValue());
                 if(isbefore && isafter)
                 {
                       tableView.getItems().add(i);
                 }
     
        }
         
      
    }

    
}
