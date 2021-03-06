package com.example.campuss;



import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

public class List implements Initializable {

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, String> firstname;

    @FXML
    private TableColumn<User, String> lastname;
    @FXML
    public Button Back;

    @FXML
    private TextField keyword;
    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;


    ObservableList<User> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String  productViewQuery = "SELECT firstname,lastname From log_reg Where rol='student'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(productViewQuery);

            while(queryOutput.next()){
                String queryfirstname = queryOutput.getString("firstname");
                String querylastname = queryOutput.getString("lastname");


                list.add(new User (queryfirstname ,querylastname));

            }
            firstname.setCellValueFactory(new PropertyValueFactory<User,String>("firstname"));
            lastname.setCellValueFactory(new PropertyValueFactory<User ,String>("lastname"));

            table.setItems(list);


    }catch (SQLException e){
        Logger.getLogger(List.class.getName()).log(Level.SEVERE,null , e);
        e.printStackTrace();
    }
   }


    public void BackOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Teacher.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void InsertOnAction(MouseEvent mouseEvent) {

    }

    public void deleteOnAction(ActionEvent event) {
        int selectedID = table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedID);
    }
}