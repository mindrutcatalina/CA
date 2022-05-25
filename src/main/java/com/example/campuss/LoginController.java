package com.example.campuss;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController implements Initializable {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    public Button loginButton;

    @FXML
    private ImageView brandingImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField enterPasswordField;
    private String rol;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("Imagini/graduation.png");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);

        File lockFile = new File("Imagini/padlock.png");
        Image lockImage = new Image(lockFile.toURI().toString());
        lockImageView.setImage(lockImage);
    }

    public void loginButtonOnAction(ActionEvent event) {

        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            validateLogin();
            getUser();
            if (rol.equals("admin")) {
                loginButton.setOnAction(actionEvent -> {
                    loginButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();

                    loader.setLocation(getClass().getResource("Administrator.fxml"));

                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                });
            } else {
                if (rol.equals("student")) {

                    loginButton.setOnAction(actionEvent -> {
                        // take customers to their screen
                        loginButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();

                        loader.setLocation(getClass().getResource("Student.fxml"));

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    });
                } else {

                    loginButton.setOnAction(actionEvent -> {
                        // take customers to their screen
                        loginButton.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();

                        loader.setLocation(getClass().getResource("Teacher.fxml"));

                        try {
                            loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        Parent root = loader.getRoot();
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.showAndWait();
                    });
                }
            }
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }

    }



    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }
    private  String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); //to be able to save in JSON format
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;
    }

    public void getUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String getRow = "SELECT * FROM log_reg WHERE username = '" + usernameTextField.getText() + "'";

        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(getRow);
            while (queryResult.next()){
                rol = queryResult.getString("rol");
            }
        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void validateLogin() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String hashedPassword = encodePassword(usernameTextField.getText(), enterPasswordField.getText());
        String verifyLogin = "SELECT count(1) FROM log_reg WHERE username = '" + usernameTextField.getText() + "' AND password ='" + hashedPassword + "'";


        try {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);


            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    //loginMessageLabel.setText("Congratulations!");

                } else {
                    loginMessageLabel.setText("Invalid login.Please try again!");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


}