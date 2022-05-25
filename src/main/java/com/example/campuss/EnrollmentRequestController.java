package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class EnrollmentRequestController {


    public Label registrationMessageLabel;
    @FXML
    private TextField nameTextField;

    @FXML
    private Button registrationButton;

    @FXML
    private TextField sem1TextField;

    @FXML
    private TextField sem2TextField;

    @FXML
    private TextField yearTextField;

    @FXML
    void registrationButton(ActionEvent event) {
        registerUser();
    }

    public void registerUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String name = nameTextField.getText();
        String year = yearTextField.getText();
        String sem1 = sem1TextField.getText();
        String sem2 = sem2TextField.getText();

        String insertFields = " INSERT INTO admin.enrollment_request(Name, Year, Subject1, Subject2)VALUES('";
        String insertValues = name + "','" + year + "','" +sem1 +"','" + sem2 +"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


            registrationMessageLabel.setText("The enrollment request has been registered successfully !");

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }

    public Parent root;





}

