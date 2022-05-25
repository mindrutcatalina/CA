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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class SubjectsAddController{

    @FXML
    public Button addButtonOnAction;

    @FXML
    private TextField nameSubjectTextField;

    @FXML
    private Label registrationMessageLabel;

    @FXML
    private TextField yearTextField;
    @FXML
    private TextField usernameTextField;

    public void addButtonOnAction(ActionEvent event) {
        addSubjects();
    }

    public Parent root;


    public void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Administrator.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addSubjects() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String subjectname = nameSubjectTextField.getText();
        String username = usernameTextField.getText();
        Integer subjectyear = Integer.valueOf(yearTextField.getText());

        String insertFields = "INSERT INTO admin.subjects (subjectname,subjectyear,username)VALUES('";
        String insertValues = subjectname + "','" + subjectyear +"','"+ username +"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationMessageLabel.setText("Subject has been registered successfully !");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }
}
