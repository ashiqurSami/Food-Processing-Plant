
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_ManagerSendAnswerOfSupplierProblemController implements Initializable {

    @FXML
    private TextField problemNoLabel;
    @FXML
    private TextArea problemTextArea;
    @FXML
    private TextArea messageTextarea;

    
    private Problem selected;
    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem resetViewMenuItem;
    public void initData(Problem u)
    {    
        if(u==null )
        {
         Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle("Warning Alert");
        a.setContentText("Please select a table row");
        a.setHeaderText(null);
        a.showAndWait();  
        }
        selected=u;
         problemNoLabel.setText(Integer.toString(selected.getProblemNo()));
         problemTextArea.setText(selected.getProblemText());
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sendButtonOnClick(ActionEvent event) {
        selected.receivedAnswer(messageTextarea.getText());
    }

    @FXML
    private void closeMenuOnClick(ActionEvent event) {
         Platform.exit();
        System.exit(0);
        
    
}

    @FXML
    private void resetViewMenuItemOnClick(ActionEvent event) {
        problemNoLabel.clear();
        problemTextArea.clear();
        messageTextarea.clear();
    }
}
