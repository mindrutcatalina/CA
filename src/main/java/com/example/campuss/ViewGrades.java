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



public class ViewGrades implements Initializable {
    @FXML
    private TableColumn<User3, Integer> grade;

    @FXML
    private TableColumn<User3, String> name;
    @FXML
    private TableColumn<User3, String> subject;

    @FXML
    private TableView<User3> table;

    private String username = LoginController.saveUsername;

    ObservableList<User3> list3 = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
      

        try{

            String  bbbb = "SELECT name,subject,grade From grades where username ='"+ username +"'";
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(bbbb);

            while(queryOutput.next()){
                String name = queryOutput.getString("name");
                String subject = queryOutput.getString("subject");
                Integer grade = queryOutput.getInt("grade");

                list3.add(new User3(name , subject,grade));

            }
            name.setCellValueFactory(new PropertyValueFactory<User3,String>("name"));
            subject.setCellValueFactory(new PropertyValueFactory<User3,String>("subject"));
            grade.setCellValueFactory(new PropertyValueFactory<User3 ,Integer>("grade"));

            table.setItems(list3);


        }catch (SQLException e){
            Logger.getLogger(List.class.getName()).log(Level.SEVERE,null , e);
            e.printStackTrace();
            e.getCause();
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
