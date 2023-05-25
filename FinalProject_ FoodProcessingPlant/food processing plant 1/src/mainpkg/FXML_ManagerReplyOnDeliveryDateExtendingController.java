
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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;


public class FXML_ManagerReplyOnDeliveryDateExtendingController implements Initializable {

    @FXML
    private TableView<SupplierIncreasingTime> viewTable;
    @FXML
    private TableColumn<SupplierIncreasingTime, String> idCol;
    @FXML
    private TableColumn<SupplierIncreasingTime, String> prevDateCol;
    @FXML
    private TableColumn<SupplierIncreasingTime, String> newDateCol;
    @FXML
    private TableColumn<SupplierIncreasingTime, String> reasonCol;
    private Manager user;
    @FXML
    private TextArea replyTextField;

    public void initData(Manager u) {
        user = u;
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idCol.setCellValueFactory(new PropertyValueFactory<SupplierIncreasingTime, String>("fromID"));
        prevDateCol.setCellValueFactory(new PropertyValueFactory<SupplierIncreasingTime, String>("previousGivenDate"));
        newDateCol.setCellValueFactory(new PropertyValueFactory<SupplierIncreasingTime, String>("newGivenDate"));
        reasonCol.setCellValueFactory(new PropertyValueFactory<SupplierIncreasingTime, String>("reason"));
        ArrayList<SupplierIncreasingTime> list = SupplierIncreasingTime.listOfSupplierIncreasingTime();
        for (SupplierIncreasingTime i : list) {
            if (i.isIsCheck()== false) {
                viewTable.getItems().add(i);

            }
        }
       
    }

    @FXML
    private void onClickBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerHomeScen.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerHomeScenController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickSendButton(ActionEvent event) throws IOException {
     
        ObservableList<SupplierIncreasingTime> selectedRows;
        selectedRows = viewTable.getSelectionModel().getSelectedItems();
        for (SupplierIncreasingTime p : selectedRows) {
            p.setAnswer(replyTextField.getText());
            p.setIsCheck(true);
            user.replyOnIncreasingTimeForDelivery(p);
        }
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Information");
            a.setContentText("Answer Sent");
            a.showAndWait();
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_ManagerReplyOnDeliveryDateExtending.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_ManagerReplyOnDeliveryDateExtendingController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

}
