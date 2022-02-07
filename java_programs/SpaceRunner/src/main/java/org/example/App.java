package org.example;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {

        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
//        stage.setFullScreen(true);
//        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
//        double width = resolution.getWidth();
//        double height = resolution.getHeight();
//        double w = width/1200 ;  // your window width
//        double h = height/900;  // your window height
//        Scale scale = new Scale(w, h, 0,0);
//        Parent root=scene.getRoot();
//        root.getTransforms().add(scale);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }

}