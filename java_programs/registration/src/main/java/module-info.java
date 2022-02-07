module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.java;
    requires java.sql;


    opens org.example to javafx.fxml;
    exports org.example;
}