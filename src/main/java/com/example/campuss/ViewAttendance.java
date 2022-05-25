package com.example.campuss;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

            String  bbbb = "SELECT name,number From grades where username ='"+ username +"'";
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(bbbb);

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

}
