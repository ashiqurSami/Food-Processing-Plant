
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class FXML_AdminUpdateCompanyDetailsController implements Initializable {

    private Admin user;
    
    @FXML 
    private TextArea detailsTextArea;

    public void initData(Admin u) {
        user = u;
    }
  

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        detailsTextArea.setText("");
        ArrayList<CompanyDetails> c = CompanyDetails.listOfCompanyDetails();
        if (c != null) {
            for (CompanyDetails i : c) {
                detailsTextArea.appendText(i.toString());
            }
        }
    }

    @FXML
    private void onClickSUbmitButton(ActionEvent event) {
        user.updateCompanyDetails(detailsTextArea.getText());
    }

    @FXML
    private void onClickBackButton(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_AdminHomeScen.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_AdminHomeScenController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }


}
