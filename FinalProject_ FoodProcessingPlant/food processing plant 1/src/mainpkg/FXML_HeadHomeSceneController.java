
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
import javafx.stage.Stage;


public class FXML_HeadHomeSceneController implements Initializable {
    private Head user;
    public void initData(Head u){
        user = u;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   /* private void createMeetingScheduleonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadCreateMeetingSchedule.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadCreateMeetingScheduleController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }*/

    @FXML
    private void viewEmployeeListonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadViewAllEmployeeList.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadViewAllEmployeeListController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    @FXML
    private void approveWorkerLeaveApplicationonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadApprovedLeaveApplication.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApprovedLeaveApplicationController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    @FXML
    private void giveNoticeonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadGiveNotice.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadGiveNoticeController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    @FXML
    private void viewandApproveProductDistributorCandidateonAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadApproveDistributorCandidateList.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApproveDistributorCandidateListController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    @FXML
    private void onClickLogOutButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_Login.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    @FXML
    private void checkInventoryButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_HeadCheckInventory.fxml"));
        Parent homeScene1 = loader.load();
        Scene homepage1 = new Scene(homeScene1);
       FXML_HeadCheckInventoryController controller = loader.getController();
        controller.initData(user);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(homepage1);
        window.show();
    }

    
}
