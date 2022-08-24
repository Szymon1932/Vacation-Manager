package Controllers;

import DatabaseConnection.DBConnection;
import Events.Listener;
import Events.LoginEvent;
import Models.User;
import com.google.common.eventbus.EventBus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static Controllers.MainController.showStage;

public class LoginController implements Initializable {
    DBConnection dbConnection = DBConnection.getInstance();
    @FXML
    private Button cancelButton;
    @FXML
    private Label messageLabel;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private ImageView logoImage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("images/vacations.png");
        Image image = new Image(file.toURI().toString());
        logoImage.setImage(image);
    }

    public void loginButtonOnAction(ActionEvent event) {
        messageLabel.setText("Incorrect data");
        if (usernameTextField.getText() != "" && passwordPasswordField.getText() != "") {

            loginValidation();
        } else {
            messageLabel.setText("Input data");
        }
    }

    public void loginValidation() {
        User user;
        String q = "SELECT * FROM users WHERE username = '" + usernameTextField.getText() + "' AND password ='" + passwordPasswordField.getText() + "' LIMIT 1";

        ResultSetHandler<User> resultSetHandler = new BeanHandler<>(User.class);
        try {
            user = dbConnection.queryRunner.query(q, resultSetHandler);
            if (user == null) {
                messageLabel.setText("Error while logging in");
            } else {
                messageLabel.setText("Logged in");
                EventBus eventBus = new EventBus();
                eventBus.register(new Listener());
                showStage("main.fxml");
                eventBus.post(new LoginEvent());
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();

            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void loginRegisterButtonOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
            showStage("register.fxml");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
