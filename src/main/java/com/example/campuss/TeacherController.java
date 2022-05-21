package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherController {

    @FXML
    private Button logoutButton;
    @FXML
    private AnchorPane scenePane;
    private Stage stage;
    private Scene scene;

    public Parent root;

    /*public void logout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout ");
        alert.setHeaderText("You're about to logout !");
        alert.setContentText("Do you want to save before existing ? :");
        if (alert.showAndWait().get() == ButtonType.OK) {
            this.stage = (Stage) this.scenePane.getScene().getWindow();
            System.out.println("You are successfully logged out ! ");
            this.stage.close();
        }*/

    }

