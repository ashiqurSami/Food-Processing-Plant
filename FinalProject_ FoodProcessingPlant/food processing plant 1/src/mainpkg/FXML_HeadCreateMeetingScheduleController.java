
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_HeadCreateMeetingScheduleController implements Initializable {
    private Head user;
    @FXML
    private TextField meetingNo;
    @FXML
    private TextField meetingTime;
    @FXML
    private DatePicker meetingDate;
    @FXML
    private TextField roomNumber;
    @FXML
    private TextField topic;
    @FXML
    private TextArea about;
    @FXML
    private TextArea viewField;
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

    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        user.createMeeting(
            meetingDate.getValue(),
            meetingTime.getText(),
            topic.getText(),
            roomNumber.getText(),
            about.getText(),
            Integer.parseInt(meetingNo.getText())
        );
        
        meetingDate.setValue(null);
        meetingTime.setText(null);
        topic.setText(null);
        roomNumber.setText(null);
        about.setText(null);
        meetingNo.setText(null);
    }

    @FXML
    private void clickOnViewMeetingButton(ActionEvent event) {
        viewField.setText("");
        ArrayList<Meeting>m = new ArrayList<>();
        m = user.viewMeetingSchedule();
        if(m != null){
            for(Meeting i: m){
                viewField.appendText(i.toString());
            }
        }
        viewField.appendText("Completed!!!");
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
