
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXML_WorkerNoticeCheckController implements Initializable {

    
    private Worker user;
    public void initData(Worker u){
        user = u;
    }
    @FXML
    private TableView<Notice> tableView;
    @FXML
    private TableColumn<Notice, String> noticeCol;
    @FXML
    private TableColumn<Notice,String> noticeTextCol;
    @FXML
    private TableColumn<Notice,LocalDate> dateCol;
    
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        noticeCol.setCellValueFactory(new PropertyValueFactory<Notice,String>("noticeSubj"));
        noticeTextCol.setCellValueFactory(new PropertyValueFactory<Notice,String>("noticeText"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Notice,LocalDate>("date"));
        ArrayList<Notice>u = Notice.listOfNotice();
       
        for(Notice i: u){
           
            System.out.println(i.toString());
            tableView.getItems().add(i);
    }   
   }

    @FXML
    private void detailedViewofNoticeButtonOnAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXML_WorkerDetailedViewOfNotice.fxml"));
        Parent regViewParent = loader.load();
        Scene regViewScene = new Scene(regViewParent);
        FXML_WorkerDetailedViewOfNoticeController controller = loader.getController();
        controller.initData(tableView.getSelectionModel().getSelectedItem());
        Stage window=new Stage(); 
        window.setScene(regViewScene);
        window.show();
        
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
