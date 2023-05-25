
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;


public class FXML_HeadViewChartController implements Initializable {

    @FXML
    private BarChart<String, Number> barChat;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAXIS;
    @FXML
    private DatePicker date;
    private Head user;
    public void initData(Head u)
    {
        user=u;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okandLoadChartButtonOnClick(ActionEvent event) {
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        ArrayList<Inventory>iList=Inventory.listOfInventory();
       
     
        for(Inventory i:iList)
        {   
             
             boolean same = i.getDate().equals( date.getValue() );
           if(same)
            {
                series.getData().add(new XYChart.Data<String,Number>(i.getPoductName(),i.getManufactureUnit())); 
               
            }
          
        }
        series.setName("Daily produce Product");
        barChat.getData().add(series);
        
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXML_HeadCheckInventory.fxml"));
        Parent homeScene1 = loader1.load();
        Scene homepage1 = new Scene(homeScene1);
        FXML_HeadCheckInventoryController controller1 = loader1.getController();
        controller1.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
    
}
