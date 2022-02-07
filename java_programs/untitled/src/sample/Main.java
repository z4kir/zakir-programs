package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage = new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 300, 275));
//        root.getStylesheets().addAll(getClass().getResource("app.css").toExternalForm());
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
