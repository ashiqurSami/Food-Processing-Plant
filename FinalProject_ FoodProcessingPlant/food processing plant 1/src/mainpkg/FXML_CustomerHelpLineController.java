
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
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class FXML_CustomerHelpLineController implements Initializable {

    
    @FXML
    private TextArea answerTextArea;
    
    private Customer user;

    public void initData(Customer u) {
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
    private void quesNo1ButtonOnClick(ActionEvent event) {
      String s=  user.answer(1);
      answerTextArea.setText(s);
      
        
    }

    @FXML
    private void quesNo2ButtonOnClick(ActionEvent event) {
       String s=  user.answer(2);
        answerTextArea.setText(s);
    }

    @FXML
    private void quesNo3ButtonOnClick(ActionEvent event) {
        String s= user.answer(3);
         answerTextArea.setText(s);
    }

    @FXML
    private void quesNo4ButtonOnClick(ActionEvent event) {
       String s = user.answer(4);
        answerTextArea.setText(s);
    }

    @FXML
    private void quesNo5ButtonOnClick(ActionEvent event) {
        String s= user.answer(5);
        answerTextArea.setText(s);
    }


    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXML_CustomerHomeScene.fxml"));
                Parent homeScene1 = loader1.load();
                Scene homepage1 = new Scene(homeScene1);
                FXML_CustomerHomeSceneController controller1 = loader1.getController();
                controller1.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
    }
    
}
