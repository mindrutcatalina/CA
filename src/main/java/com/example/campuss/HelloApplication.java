package com.example.campuss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Administrator.fxml")));
            Scene scene1 = new Scene(root);
            stage.setScene(scene1);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        launch();
    }
}