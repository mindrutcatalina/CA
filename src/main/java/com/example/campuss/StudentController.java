package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.EventObject;
import java.util.Objects;

public class StudentController {

    public Parent root;

    public void logoutButtonOnAction(ActionEvent actionEvent) {
    }

    public void subjectsButtonOnAction(ActionEvent actionEvent) {
    }

    public void messageButtonOnAction(ActionEvent actionEvent) {
    }

    public void attendaceButtonOnAction(ActionEvent actionEvent) {
    }

    public void gradesButtonOnAction(ActionEvent actionEvent) {
    }

    public void back(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("DateExam.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
