package com.example.campuss;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

public class AttendanceController implements Initializable {
    @FXML
    private Button myButton;

    @FXML
    private Label myLabel;

    @FXML
    private ProgressBar myProgressBar;

    double progress ;

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
}
