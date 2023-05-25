
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXML_WorkerCheckIncentiveSceneController implements Initializable {
    private Worker user;
    @FXML
    private TableView<Incentive> tableView;
    @FXML
    private TableColumn<Incentive,String> idColoumn;
    @FXML
    private TableColumn<Incentive,String> amountColoumn;
    @FXML
    private TableColumn<Incentive,String> dateColoumn;
    public void initData(Worker u) {
        user = u;
        idColoumn.setCellValueFactory(new PropertyValueFactory<Incentive, String>("toID"));
        amountColoumn.setCellValueFactory(new PropertyValueFactory<Incentive, String>("amount"));
        dateColoumn.setCellValueFactory(new PropertyValueFactory<Incentive, String>("date"));
       
        ArrayList<Incentive> p = user.viewIncentiveList();
        for (Incentive i : p) {
                tableView.getItems().add(i);
            }
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
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
}
