package com.example.campuss;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class AttendanceLabController {


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;
    @FXML
    private TextField usernameTextField;

    @FXML
    void addButtonLab(ActionEvent event) {
        addButtonLab();
    }
    @FXML
    private Label registrationMessageLabel;

    public void addButtonLab() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String name = nameTextField.getText();
        Integer number = Integer.valueOf(numberTextField.getText());
        String username = usernameTextField.getText();

        String insertFields = "INSERT INTO admin.present(name,number,username) VALUES('";
        String insertValues = name + "','" + number + "','" + username +"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


            registrationMessageLabel.setText("Laboratory attendance has been registered successfully !");

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
