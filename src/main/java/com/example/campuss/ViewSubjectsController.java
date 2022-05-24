package com.example.campuss;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViewSubjectsController implements Initializable {


    @FXML
    private TableColumn<User2, String> subjectname;


    @FXML
    public Button Back;
    @FXML
    private TableView<User2> tableV;


    ObservableList<User2> list1 = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String  aaa = "SELECT subjectname from subjects ";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(aaa);

            while(queryOutput.next()){
                String subjectname = queryOutput.getString("subjectname");


                list1.add(new User2 (subjectname));

            }
            subjectname.setCellValueFactory(new PropertyValueFactory<User2,String>("subjectname"));


            tableV.setItems(list1);


        }catch (SQLException e){
            Logger.getLogger(List.class.getName()).log(Level.SEVERE,null , e);
            e.printStackTrace();
        }
    }


    public void backOnAction(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Student.fxml")));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

