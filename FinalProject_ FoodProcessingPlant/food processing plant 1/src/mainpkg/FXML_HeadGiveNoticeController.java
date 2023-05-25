
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_HeadGiveNoticeController implements Initializable {

    private Head user;

    public void initData(Head u) {
        user = u;
    }
    @FXML
    private TextArea noticeBodyTextArea;
    @FXML
    private TextField noticeSubjectTextField;
    @FXML
    private TextArea viewNoticeTextAreaTextField;
    @FXML
    private DatePicker noticeDatePicker;

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
        loader1.setLocation(getClass().getResource("FXML_HeadHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
         user.giveNoticeToWorker(noticeBodyTextArea.getText(),noticeSubjectTextField.getText(),noticeDatePicker.getValue());
         noticeBodyTextArea.clear();
         noticeSubjectTextField.clear();
         noticeDatePicker.setValue(null);
    }

    @FXML
    private void viewNoticeOnClick(ActionEvent event) {
        ArrayList<Notice> nList=new ArrayList<>();
        nList=user.viewNotice();
        viewNoticeTextAreaTextField.setText("");
        if(nList != null){
            for(Notice i: nList){
                viewNoticeTextAreaTextField.appendText(i.toString());
            }
        }
    }
}
