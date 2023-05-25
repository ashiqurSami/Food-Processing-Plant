
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXML_WorkerDetailedViewOfNoticeController implements Initializable {

    @FXML
    private MenuItem closeMenu;
    @FXML
    private MenuItem resetViewMenuItem;

    @FXML
    private TextField subjectTextfield;
    @FXML
    private TextArea noticeTextArea;
    
    private Notice selected;
    @FXML
    private TextField dateLabel;
    public void initData(Notice u)
    {
        selected=u;
       
        subjectTextfield.setText(selected.getNoticeSubj());
        noticeTextArea.setText(selected.getNoticeText());   
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void closeMenuOnClick(ActionEvent event) {
        Platform.exit();
        System.exit(0);
        
    }

    @FXML
    private void resetViewMenuItemOnClick(ActionEvent event) {
         dateLabel.clear();
        subjectTextfield.clear();
        noticeTextArea.clear();  
        
    }
    
}
