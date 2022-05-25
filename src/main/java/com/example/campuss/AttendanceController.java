package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {
    @FXML
    private Button myButton;

    @FXML
    private Label myLabel;

    @FXML
    private ProgressBar myProgressBar;

    double progress ;

    public Parent root;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        myProgressBar.setStyle("-fx-accent: #00FF00");
    }

    public void increaseProgress() {
        if (progress< 1) {
            progress +=0.1;
            System.out.println(progress);
            myProgressBar.setProgress(progress);
            myLabel.setText(Integer.toString((int) Math.round(progress * 100)) + "%");
        }
    }

    public void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Teacher.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
