package com.example.campuss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DataExamController {
    @FXML
    public DatePicker myDatePicker;
    @FXML
    public DatePicker myDatePicker1;
    @FXML
    public DatePicker myDatePicker2;
    @FXML
    public DatePicker myDatePicker3;
    @FXML
    public DatePicker myDatePicker4;
    @FXML
    public DatePicker myDatePicker5;
    @FXML
    public DatePicker myDatePicker6;
    @FXML
    public Label myLabel1;
    @FXML
    public Label myLabel2;
    @FXML
    public Label myLabel3;
    @FXML
    public Label myLabel4;
    @FXML
    public Label myLabel5;
    @FXML
    public Label myLabel6;
    @FXML
    public Label myLabel7;

    public Parent root;
   // public Button Back1;


    public void getDate(ActionEvent event){
        LocalDate myDate = myDatePicker.getValue();
       // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel1.setText(myDate.toString());
    }
    public void getDate1(ActionEvent event){
        LocalDate myDate = myDatePicker3.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel2.setText(myDate.toString());
    }
    public void getDate2(ActionEvent event){
        LocalDate myDate = myDatePicker1.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel3.setText(myDate.toString());
    }

    public void getDate3(ActionEvent event){
        LocalDate myDate = myDatePicker2.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel4.setText(myDate.toString());
    }

    public void getDate4(ActionEvent event){
        LocalDate myDate = myDatePicker4.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel5.setText(myDate.toString());
    }

    public void getDate5(ActionEvent event){
        LocalDate myDate = myDatePicker5.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel6.setText(myDate.toString());
    }
    public void getDate6(ActionEvent event){
        LocalDate myDate = myDatePicker6.getValue();
        // System.out.println(myDate.toString());
        String myFormattedDate =myDate.format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        myLabel7.setText(myDate.toString());
    }


    public void Back1(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Administrator.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
