package Threads;

import com.example.edp.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalendarPricesThread extends Thread {

    @Override
    public void start() {
        try {
            showStage("calendar-prices-result.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void showStage(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(name));
        Scene scene = new Scene(fxmlLoader.load());
        Stage registerStage = new Stage();
        registerStage.setTitle("Vacation Planner");
        registerStage.setScene(scene);
        registerStage.show();
    }
}
