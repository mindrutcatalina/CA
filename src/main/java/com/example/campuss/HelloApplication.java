package com.example.campuss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Student.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                logout(stage);
            });

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void logout(Stage stage){



        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout ");
        alert.setHeaderText(("You're about to logout !"));
        alert.setContentText("Do you want to save before existing ? :");

        if (alert.showAndWait().get()== ButtonType.OK) {
            System.out.println("You are successfully logged out ! ");
            stage.close();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}