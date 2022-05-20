package com.example.campuss;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
public class AdministratorController {

    @FXML
    private Label welcomeText;

    private Stage stage;
    private Scene scene;

    public Parent root;

    public void SwitchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;


        public void logout(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout ");
            alert.setHeaderText("You're about to logout !");
            alert.setContentText("Do you want to save before existing ? :");
            if (alert.showAndWait().get() == ButtonType.OK) {
                this.stage = (Stage) this.scenePane.getScene().getWindow();
                System.out.println("You are successfully logged out ! ");
                this.stage.close();
            }

        }
    }



