package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PrimaryController {


    @FXML
    private TextField name;

    @FXML
    private TextField RollNo;

    @FXML
    private TextField std;

    @FXML
    private TextArea address;

    @FXML
    private TextField mobile;

    @FXML
    private Label label;

    @FXML
    private TableView<Record> table;

    @FXML
    private TableColumn<Record, String> nameclm;

    @FXML
    private TableColumn<Record, String> rollnoclm;

    @FXML
    private TableColumn<Record, String> stdclm;

    @FXML
    private TableColumn<Record, String> addclm;

    @FXML
    private TableColumn<Record, String> mobileclm;

    Connection con;

    PreparedStatement stmt;


    @FXML
    void table() {
        ObservableList<Record> records = FXCollections.observableArrayList();
        try {
            stmt = con.prepareStatement("select * from student_information");
            ResultSet rst = stmt.executeQuery();
            while (rst.next()) {
                Record record = new Record();
                record.setName(rst.getString("name"));
                record.setRollNo(rst.getString("rollno"));
                record.setStd(rst.getString("standard"));
                record.setAddress(rst.getString("address"));
                record.setMobile(rst.getString("mobile"));
                records.add(record);

            }
            table.setItems(records);
            nameclm.setCellValueFactory(f -> f.getValue().nameProperty());
            rollnoclm.setCellValueFactory(f -> f.getValue().rollNoProperty());
            stdclm.setCellValueFactory(f -> f.getValue().stdProperty());
            addclm.setCellValueFactory(f -> f.getValue().stdProperty());
            mobileclm.setCellValueFactory(f -> f.getValue().mobileProperty());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void add(ActionEvent event) {
        if (name.getText().isEmpty() && RollNo.getText().isEmpty() && std.getText().isEmpty() && address.getText().isEmpty() && mobile.getText().isEmpty()) {
            label.setText("please insert all the information");
        } else {
            try {
//                String driver="com.mysql.cj.jdbc.Driver";
//                String url="jdbc:mysql://localhost:3306/student_registration";
//                String username="root";
//                String password="zak78684";
//
//
//                Class.forName(driver);
//
//                con = DriverManager.getConnection(url,username,password);


                stmt = con.prepareStatement("INSERT INTO student_information(name,rollno,standard,address,mobile) VALUES (?,?,?,?,?)");
                stmt.setString(1, name.getText());
                stmt.setString(2, RollNo.getText());
                stmt.setString(3, std.getText());
                stmt.setString(4, address.getText());
                stmt.setString(5, mobile.getText());

                label.setText("");


                int status = stmt.executeUpdate();

                if (status == 1) {


                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);

                    alert.setHeaderText("add successfully");

                    alert.show();

                    name.setText("");
                    RollNo.setText("");
                    std.setText("");
                    address.setText("");
                    mobile.setText("");


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "", ButtonType.OK);
                    alert.setHeaderText("failed");
                    alert.show();

                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            table();
        }

    }

    @FXML
    public void initialize() throws Exception {
        System.out.println("ppp.....");
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/student_registration";
        String username = "root";
        String password = "zak78684";


        Class.forName(driver);

        con = DriverManager.getConnection(url, username, password);
        table();

    }


}
