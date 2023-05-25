
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXML_DetailoedSupplierRegistrationViewController implements Initializable {

    @FXML
    private TextArea descriptiontTextArea;
    @FXML
    private TextField idLabel;
    @FXML
    private TextField materialNameLabel;
    @FXML
    private TextField divsionLabel;
    @FXML
    private TextField districtLabel;
    @FXML
    private TextField durationMonthLabel;
    @FXML
    private TextField regNoLabel;
    private NewRawMaterial selected;
    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem resetViewMenuItem;
    public void initData(NewRawMaterial u)
    {   
        if(u==null)
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Warning Alert");
            a.setContentText("Select a table row please!");
            a.setHeaderText(null);
            a.showAndWait();  
        }
        else
        {
            
        selected=u;
        LocalDate localDate = LocalDate.now();
        idLabel.setText(selected.getId());
        materialNameLabel.setText(selected.getMaterialName());
        divsionLabel.setText(selected.getDivision());
        districtLabel.setText(selected.getDistrict());
        durationMonthLabel.setText(selected.getDurationMonth());
        regNoLabel.setText(selected.getRegNo());
        descriptiontTextArea.setText(selected.getDescription());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void backButtonOnClick(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void closeMenuOnClick(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void resetViewMenuItemOnClick(ActionEvent event) {
        descriptiontTextArea.clear();
        idLabel.clear();
        materialNameLabel.clear();
        divsionLabel.clear();
        districtLabel.clear();
        durationMonthLabel.clear();
        regNoLabel.clear();
        
        
    }
    
}
