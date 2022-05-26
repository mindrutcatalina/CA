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

public class ViewRequest implements Initializable {


    @FXML
    private TableColumn<User4, String> Name;
    @FXML
    private TableColumn<User4, String> Subject1;
    @FXML
    private TableColumn<User4, String> Subject2;
    @FXML
    private TableColumn<User4, Integer> Year;

    @FXML
    private TableView<User4> table;


    ObservableList<User4> list4 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();


        try{

            String  cccc = "SELECT Name,Year,Subject1,Subject2 from enrollment_request";
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(cccc);

            while(queryOutput.next()){
                String name = queryOutput.getString("Name");
                Integer year = queryOutput.getInt("Year");
                String sem1 = queryOutput.getString("Subject1");
                String sem2 = queryOutput.getString("Subject2");


                list4.add(new User4(name,year, sem1,sem2));

            }
            Name.setCellValueFactory(new PropertyValueFactory<User4,String>("Name"));
            Year.setCellValueFactory(new PropertyValueFactory<User4 ,Integer>("Year"));
            Subject1.setCellValueFactory(new PropertyValueFactory<User4,String>("Subject1"));
            Subject2.setCellValueFactory(new PropertyValueFactory<User4,String>("Subject2"));


            table.setItems(list4);


        }catch (SQLException e){
            Logger.getLogger(List.class.getName()).log(Level.SEVERE,null , e);
            e.printStackTrace();
            e.getCause();
        }
    }


    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Teacher.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}


