
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXML_ManagerViewAndAnswerSupplierProblemController implements Initializable {

    @FXML
    private TableView<Problem> tableView;
    @FXML
    private TableColumn<Problem, String> idColoumn;
    @FXML
    private TableColumn<Problem, String> problemNoColoumn;
    @FXML
    private TableColumn<Problem, String> problemTextColoumn;
    
    private Manager user;

    public void initData(Manager u) {
        user = u;
    }
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        idColoumn.setCellValueFactory(new PropertyValueFactory<Problem, String>("fromID"));
        problemNoColoumn.setCellValueFactory(new PropertyValueFactory<Problem, String>(" problemNo"));
        problemTextColoumn.setCellValueFactory(new PropertyValueFactory<Problem, String>("problemText"));
      
       
        ArrayList<Problem> u = Problem.problemList();
       
        
        for (Problem i : u) {
            if(!i.isIsCheck())
            {
                tableView.getItems().add(i);
            
            }
              
                
        }
        
         
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
    private void sendMessageButtonOnClick(ActionEvent event) throws IOException {
     
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_ManagerSendAnswerOfSupplierProblem.fxml"));
        Parent regViewParent = loader.load();
        Scene regViewScene = new Scene(regViewParent);
        FXML_ManagerSendAnswerOfSupplierProblemController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        Stage window=new Stage(); 
        window.setScene(regViewScene);
        window.show();
        
       
    }
    
}
