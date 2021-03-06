package com.example.campuss;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    public TextField firstnameTextField;
    @FXML
    public TextField lastnameTextField;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField emailTextField;
    @FXML
    public TextField phonenumberTextField;
    @FXML
    public TextField rolTextField;
    @FXML
    public Button registerButton;
    @FXML
    public Label confirmPasswordLabel;
    @FXML
    private ImageView shieldImageView;
    @FXML
    public Button closeButton;
    @FXML
    public Button backButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    public TextField setPasswordField;

    @FXML
    public TextField confirmPasswordField;


    public void initialize(URL url, ResourceBundle resourceBundle) {
        File imagine1 = new File("Imagini/user.png");
        Image picture = new Image(imagine1.toURI().toString());
        shieldImageView.setImage(picture);
    }

    public void registerButtonOnAction(ActionEvent event){
        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser();

        }else{
            confirmPasswordLabel.setText("Password does not match.");
        }
    }
    public void backButtonOnAction(ActionEvent event) throws IOException {
        Stage window = (Stage) backButton.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Administrator.fxml" ));
        window.setScene(new Scene(root,800,600));

    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
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

    public void registerUser(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String rol = rolTextField.getText();
        String email = emailTextField.getText();
        String phonenumber = phonenumberTextField.getText();
        String username = usernameTextField.getText();
        String password = encodePassword(usernameTextField.getText() , setPasswordField.getId());


        String insertFields = "INSERT INTO log_reg(firstname, lastname,rol,email,phonenumber,username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" +rol +"','" + email +"','" + phonenumber +"','" + username + "','" + password +"')";
        String insertToRegister = insertFields + insertValues;



        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


            registrationMessageLabel.setText("User has been registered successfully !");

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }
}