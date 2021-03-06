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

public class ViewAttendance implements Initializable {

    @FXML
    private TableColumn<User5, String> name;

    @FXML
    private TableColumn<User5, Integer> number;

    @FXML
    private TableView<User5> table;

    private String username = LoginController.saveUsername;

    ObservableList<User5> list5 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        try{

            String  ggg = "SELECT name,number From present where username ='"+ username +"'";
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(ggg);

            while(queryOutput.next()){
                String name = queryOutput.getString("name");
                Integer number = queryOutput.getInt("number");

                list5.add(new User5(name , number));

            }
            name.setCellValueFactory(new PropertyValueFactory<User5,String>("name"));
            number.setCellValueFactory(new PropertyValueFactory<User5 ,Integer>("number"));

            table.setItems(list5);


        }catch (SQLException e){
            Logger.getLogger(List.class.getName()).log(Level.SEVERE,null , e);
            e.printStackTrace();
            e.getCause();
        }
    }

    public void Back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Student.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
