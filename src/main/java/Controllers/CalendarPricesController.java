package Controllers;

import Models.CalendarPrices;
import Models.Datum;
import Threads.CalendarPricesThread;
import com.example.edp.Main;
import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CalendarPricesController {
    public static List<Datum> dataApi1;
    @FXML
    private TextField currencyTextField;
    @FXML
    private TextField originTextField;
    @FXML
    private TextField destinationTextField;
    @FXML
    private Button cancelButton;
    @FXML
    private Label messageLabel;

    private List<Datum> createData(){
        String token = "cd5e2cff52c344885b5c83a3a11b328c";
        String currency = currencyTextField.getText();
        String showToAffiliates = "true";
        String origin = originTextField.getText();
        String destination = destinationTextField.getText();

        String urlRequest = String.format("https://api.travelpayouts.com/v2/prices/month-matrix?currency=%s&show_to_affiliates=%s&origin=%s&destination=%s", currency, showToAffiliates, origin, destination);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(urlRequest))
                .header("X-Access-Token", token)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        CompletableFuture<HttpResponse<String>> cf = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> response = cf.join();

        CalendarPrices calendarPrices = new Gson().fromJson(response.body(), CalendarPrices.class);

        List<Datum> data = calendarPrices.getData();
        return data;
    }

    public void resultButtonOnAction(ActionEvent event) {
        dataApi1 = createData();
        if (dataApi1 == null) {
            messageLabel.setText("Brak wyników");
        } else {
            messageLabel.setText("");
            CalendarPricesThread cpt = new CalendarPricesThread();
            cpt.start();
        }

    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
        showStage("main.fxml");
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
