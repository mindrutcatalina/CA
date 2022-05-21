package com.example.campuss;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AdministratorController implements Initializable {

    @FXML
    private Label welcomeText;
    @FXML
    private ImageView teachearsImageView;
    @FXML
    private ImageView subjectImageView;

    @FXML
    private ImageView studentImageView;
    @FXML
    private Button logoutButton;

    private Stage stage;
    private Scene scene;
    public Parent root;
    private AnchorPane scenePane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File teachearsFile = new File("Imagini/teachears.jpg");
        Image teachearsImage = new Image(teachearsFile.toURI().toString());
        teachearsImageView.setImage(teachearsImage);

        File studentFile = new File("Imagini/students2.jpg");
        Image studentImage = new Image(studentFile.toURI().toString());
        studentImageView.setImage(studentImage);

        File subjectFile = new File("Imagini/subject.png");
        Image subjectImage = new Image(subjectFile.toURI().toString());
        subjectImageView.setImage(subjectImage);

    }

        public void logoutButtonOnAction(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Logout ");
            alert.setHeaderText("You're about to logout !");
            alert.setContentText("Do you want to save before existing ? :");
            if (alert.showAndWait().get() == ButtonType.OK) {
                this.stage = (Stage) this.scenePane.getScene().getWindow();
                System.out.println("You are successfully logged out ! ");
                this.stage.close();
            }

        }



    public void SwitchToRegister(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Register.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}