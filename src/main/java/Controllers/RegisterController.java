package Controllers;

import DatabaseConnection.DBConnection;
import Models.User;
import com.example.edp.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class RegisterController {

    DBConnection dbConnection = DBConnection.getInstance();

    @FXML
    private Button cancelButton;

    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private Label messageLabel;

    public void registerButtonOnAction(ActionEvent event) {

        if (usernameTextField.getText() == "" || passwordPasswordField.getText() == "" || firstnameTextField.getText() == "" || lastnameTextField.getText() == "") {
            messageLabel.setText("Uzupełnij brakujace pola");
        } else {
            registerUser();
        }
    }


    public void cancelButtonOnAction(ActionEvent event) {
        try {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage registerStage = new Stage();
            registerStage.setTitle("Vacation Planner");
            registerStage.setScene(scene);
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void registerUser() {
        String q = "INSERT INTO users (username, password, firstname,lastname) VALUES('" + usernameTextField.getText() + "', '" + passwordPasswordField.getText() + "', '" + firstnameTextField.getText() + "', '" + lastnameTextField.getText() + "')";

        ResultSetHandler<User> resultSetHandler = new BeanHandler<User>(User.class);
        try {
            dbConnection.queryRunner.insert(q, resultSetHandler);
            messageLabel.setText("Registration successful");


        } catch (SQLException e) {
            messageLabel.setText("Error while creating account");
            e.printStackTrace();
        }
    }

}
