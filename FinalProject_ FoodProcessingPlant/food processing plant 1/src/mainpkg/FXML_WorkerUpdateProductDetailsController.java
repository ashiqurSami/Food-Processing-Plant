
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_WorkerUpdateProductDetailsController implements Initializable {

    private Worker user;

    public void initData(Worker u) {
        user = u;
    }
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea detailsTextArea;
    @FXML
    private TextField priceTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        user.updateCompanyProductDetails(
                Integer.parseInt(idTextField.getText()),
                nameTextField.getText(),
                detailsTextArea.getText(),
                priceTextField.getText()
        );
        idTextField.setText(null);
        nameTextField.setText(null);
        detailsTextArea.setText(null);
        priceTextField.setText(null);
    }

    @FXML
    private void onClickBackButton(ActionEvent event) throws IOException {
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
