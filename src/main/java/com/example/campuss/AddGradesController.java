package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class AddGradesController {

    @FXML
    public TextField gradeTextField;

    @FXML
    public TextField namestudentTextField;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    public void AddOnActionButton(ActionEvent event) {
         AddOnActionButton();
    }


    public void AddOnActionButton() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String name = namestudentTextField.getText();
        Integer grade = Integer.valueOf(gradeTextField.getText());

        String insertFields = "INSERT INTO admin.grades(name,grade) VALUES('";
        String insertValues = name + "','" + grade + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("Grade has been registered successfully !");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Teacher.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
