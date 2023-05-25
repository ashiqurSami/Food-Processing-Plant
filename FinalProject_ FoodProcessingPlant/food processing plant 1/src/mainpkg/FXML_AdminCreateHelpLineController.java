
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXML_AdminCreateHelpLineController implements Initializable {

    @FXML
    private ComboBox<String> quesNoComboBox;
    @FXML
    private TextArea answerTextArea;

    /**
     * Initializes the controller class.
     */
    private Admin user;
    public void initData(Admin u)
    {
        user=u;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quesNoComboBox.getItems().addAll("1","2","3","4","5");
        // TODO
    }    

    @FXML
    private void submitButtonONClick(ActionEvent event) {
        user.setFaqAns(quesNoComboBox.getValue(),answerTextArea.getText());
        answerTextArea.clear();
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_AdminHomeScen.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_AdminHomeScenController controller1 = loader1.getController();
                controller1.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
    }
    
}
