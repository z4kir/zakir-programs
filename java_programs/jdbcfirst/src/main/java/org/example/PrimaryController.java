package org.example;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.*;


public class PrimaryController {

    @FXML
    private TextField un;

    @FXML
    private TextField pw;

    @FXML
    private Button primaryButton;

    @FXML
    private Label label;


    @FXML
    private void switchToSecondary() throws IOException {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/login";
            String username = "root";
            String password = "zak78684";


            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, username, password);


            PreparedStatement stmt = con.prepareStatement("Select * from login_table where username=? and password=?");

            stmt.setString(1, un.getText());
            stmt.setString(2, pw.getText());
            ResultSet ret = stmt.executeQuery();
            label.setText("Connected");
            if (ret.next()) {

//                   App app=new App();
//                   app.newStage();

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);

                alert.setHeaderText("login successfull");

                alert.show();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
