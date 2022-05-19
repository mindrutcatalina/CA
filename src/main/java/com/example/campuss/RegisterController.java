package com.example.campuss;

import javafx.application.Platform;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    public TextField firstnameTextField;
    @FXML
    public TextField lastnameTextField;
    @FXML
    public TextField usernameTextField;
    @FXML
    public Button registerButton;
    @FXML
    public Label confirmPasswordLabel;
    @FXML
    private ImageView shieldImageView;
    @FXML
    public Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    public TextField setPasswordTextField;
    @FXML
    public TextField confirmPasswordField;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imagine1 = new File("Desktop/user.png");
        Image picture = new Image(imagine1.toURI().toString());
        shieldImageView.setImage(picture);
    }

    public void registerButtonOnAction(ActionEvent event) {
        if (setPasswordTextField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            confirmPasswordLabel.setText((" "));
            registrationMessageLabel.setText("User has been registered successfully !");
        } else {
            confirmPasswordLabel.setText("Password does not match.");
        }
        registerUser();
    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerUser() {

    }
}

