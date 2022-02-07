module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.web;
    requires javafx.media;

    opens org.example to javafx.fxml;
    exports org.example;
}