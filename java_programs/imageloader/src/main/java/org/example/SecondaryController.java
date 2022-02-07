package org.example;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable {

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab newT;

    @FXML
    private Tab tab1;

    @FXML
    private Button search;

    @FXML
    private TextField textfield;


    @FXML
    private Label label;


    private int counter = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    void newTab(Event event) throws CloneNotSupportedException {
        if (tabPane.getTabs().size() == 1) {
            Stage stage = (Stage) tabPane.getScene().getWindow();
            stage.close();
        }
        Tab tab = new Tab("tab_" + (counter + 1));

        try {
            Parent root = FXMLLoader.load(getClass().getResource("borderpane.fxml"));
            tab.setContent(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        tabPane.getTabs().add(tabPane.getTabs().size() - 1, tab);
        tab.setStyle(tab1.getStyle());
        tabPane.getSelectionModel().select(tabPane.getTabs().size() - 2);

        counter++;

    }

    @FXML
    void action(ActionEvent event) {
        label.setText(textfield.getText());
    }


}
