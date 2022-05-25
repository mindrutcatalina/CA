
package com.example.campuss;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;

        import java.sql.Connection;
        import java.sql.Statement;

public class AttendanceLabController {


    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    void addButtonLab(ActionEvent event) {
        addButtonLab();
    }
    @FXML
    private Label registrationMessageLabel;

    public void addButtonLab() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String name = nameTextField.getText();
        Integer number = Integer.valueOf(numberTextField.getText());

        String insertFields = "INSERT INTO admin.present(name,number) VALUES('";
        String insertValues = name + "','" + number +"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);


            registrationMessageLabel.setText("Laboratory attendance has been registered successfully !");

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }
    }

}
