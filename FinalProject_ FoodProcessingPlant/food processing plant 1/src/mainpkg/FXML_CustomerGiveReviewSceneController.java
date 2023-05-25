
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXML_CustomerGiveReviewSceneController implements Initializable {

    private Customer user;

    @FXML
    private TextField proNameTextField;
    @FXML
    private TextField cusID;
    @FXML
    private TextField cusNameTextField;
    @FXML
    private ComboBox<String> onTime;
    @FXML
    private ComboBox<String> satisfaction;
    @FXML
    private TextArea cmnt;
    @FXML
    private TextArea viewProTextArea;

    public void initData(Customer u) {
        user = u;
        cusID.setText(Integer.toString(user.getId()));
        cusNameTextField.setText(user.getName());
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewProTextArea.setText("");
        ArrayList<PoductDetails> pList = PoductDetails.listOfPoductDetails();
        for (PoductDetails i : pList) {
            viewProTextArea.appendText(i.toString());
        }
        onTime.getItems().addAll("1","2","3","4","5");
        satisfaction.getItems().addAll("1","2","3","4","5");
    }

    @FXML
    private void onClickHomeSceneButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_CustomerHomeScene.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_CustomerHomeSceneController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        user.giveReview(
                proNameTextField.getText(),
                cmnt.getText(),
                cusNameTextField.getText(),
                Integer.parseInt(satisfaction.getValue()),
                Integer.parseInt(onTime.getValue()),
                user.getId()
        );
        proNameTextField.setText(null);
        cmnt.setText(null);
        satisfaction.setValue(null);
        onTime.setValue(null);
    }

}
