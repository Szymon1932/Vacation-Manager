package Controllers;

import com.example.edp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button cancelButton;
    @FXML
    private ImageView logoImage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        File file = new File("images/vacations.png");
        Image image = new Image(file.toURI().toString());
        logoImage.setImage(image);
    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        showStage("login.fxml");
    }

    public void calendarPricesOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        showStage("calendar-prices.fxml");
    }
    public void alternativePricesOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        showStage("alternative-prices.fxml");
    }
    public static void showStage(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name));
        Scene scene = new Scene(fxmlLoader.load());
        Stage registerStage = new Stage();
        registerStage.setTitle("Vacation Planner");
        registerStage.setScene(scene);
        registerStage.show();
    }
}
