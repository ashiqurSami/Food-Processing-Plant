
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


public class FXML_HeadApproveDistributorCandidateListController implements Initializable {

    private Head user;

    public void initData(Head u) {
        user = u;
    }
    @FXML
    private TableView<DistributorApplication> tableView;
    @FXML
    private TableColumn<DistributorApplication, String> idCol;
    @FXML
    private TableColumn<DistributorApplication, String> nameCol;
    @FXML
    private TableColumn<DistributorApplication, String> divisionCol;
    @FXML
    private TableColumn<DistributorApplication, String> districtCol;
    @FXML
    private TableColumn<DistributorApplication, String> phoneCol;
    @FXML
    private TableColumn<DistributorApplication, String> remarksCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nameCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("applicantName"));
        idCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("applicantID"));
        divisionCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("division"));
        districtCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("district"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("phone"));
        remarksCol.setCellValueFactory(new PropertyValueFactory<DistributorApplication, String>("remarks"));

        ArrayList<DistributorApplication> u = DistributorApplication.listOfDistributorApplication();
        for (DistributorApplication i : u) {
            if (i.getIsChecked() == false) {
                tableView.getItems().add(i);
            }
        }
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    @FXML
    private void onClickDisappoveButton(ActionEvent event) throws IOException {
        ObservableList<DistributorApplication> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (DistributorApplication p : selectedRows) {
            user.approvedDistributorCandidateApplication(p, false, true);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Disapproved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadApproveDistributorCandidateList.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApproveDistributorCandidateListController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickApproveButton(ActionEvent event) throws IOException {
        ObservableList<DistributorApplication> selectedRows;
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (DistributorApplication p : selectedRows) {
            user.approvedDistributorCandidateApplication(p, true, true);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Approved");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadApproveDistributorCandidateList.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadApproveDistributorCandidateListController controller1 = loader1.getController();
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
