
package mainpkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class FoodprocessingPlant extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
     
       Parent root = FXMLLoader.load(getClass().getResource("FXML_Login.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("FXML_AdminCreateUser.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}

