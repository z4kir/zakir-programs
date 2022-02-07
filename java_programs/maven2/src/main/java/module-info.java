module org.example {


    requires javafx.control;
    requires javafx.fxml;
    opens org.example to javafx.fxml;
    exports org.example;

}