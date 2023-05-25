
package mainpkg;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXML_HeadApprovedLeaveApplicationController implements Initializable {

    private Head user;

    public void initData(Head u) {
        user = u;
    }

    @FXML
    private TableView<LeaveApplication> tableView;
    @FXML
    private TableColumn<LeaveApplication, String> idCol;
    @FXML
    private TableColumn<LeaveApplication, String> nameCol;
    @FXML
    private TableColumn<LeaveApplication, String> fromDateCol;
    @FXML
    private TableColumn<LeaveApplication, String> toDateCol;
    @FXML
    private TableColumn<LeaveApplication, String> reasonCol;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<LeaveApplication, String>("applicantID"));
        idCol.setCellValueFactory(new PropertyValueFactory<LeaveApplication, String>("applicantID"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<LeaveApplication, String>("reason"));
        fromDateCol.setCellValueFactory(new PropertyValueFactory<LeaveApplication, String>("from"));
        toDateCol.setCellValueFactory(new PropertyValueFactory<LeaveApplication, String>("to"));

        ArrayList<LeaveApplication> u = LeaveApplication.listOLeaveApplication();
        for (LeaveApplication i : u) {
            if (i.isIsCheck() == false) {
                tableView.getItems().add(i);
            }
        }
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void onClickDisappoveButton(ActionEvent event) throws IOException {
        ObservableList<LeaveApplication> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (LeaveApplication p : selectedRows) {
            user.approvedLeaveApplication(p, false, true);
        }
          Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Disapproved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadApprovedLeaveApplication.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApprovedLeaveApplicationController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickApproveButton(ActionEvent event) throws IOException {
        ObservableList<LeaveApplication> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (LeaveApplication p : selectedRows) {
            user.approvedLeaveApplication(p, true, true);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Approved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadApprovedLeaveApplication.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApprovedLeaveApplicationController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
}
