package com.example.maketstock.controllers;

import com.example.maketstock.HelloApplication;
import com.example.maketstock.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AuthController {
    @FXML
    private PasswordField passwordPasswordField;
    @FXML
    private TextField usernameTextField;

    @FXML
    private void onRegister() throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("register.fxml")));
        Stage stage = (Stage) usernameTextField.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void onSubmitRegister() throws IOException, SQLException {
        String username = usernameTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();
        if (!username.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.register(user);
            Parent root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("hello-view .fxml")));
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(new Scene(root));
        }
    }

    @FXML
    private void onSubmitSignIn() throws IOException, SQLException {
        String username = usernameTextField.getText().trim();
        String password = passwordPasswordField.getText().trim();
        if (!username.isEmpty() && !password.isEmpty()) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            if (user.signIn(user)) {
                Stage stage = (Stage) usernameTextField.getScene().getWindow();
                Stage newStage = new Stage();
                Parent root =
                        FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource("home.fxml"
                        )));
                newStage.setTitle("iStock");
                newStage.setScene(new Scene(root));
                newStage.show();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Echec d'authentification");
                alert.setHeaderText("Nom d'utilisateur ou mot de passe incorrect(s)");
                alert.setContentText("Nous ne parvenons pas à vous connecter à votre session avec ces identifiants. vérifiez-les puis réessayez.");
                alert.show();
            }
        }
    }

}
