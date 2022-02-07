package org.example;

import javafx.beans.value.ObservableListValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PrimaryController implements Initializable {

    @FXML
    private WebView webView;

    @FXML
    private TextField searchTextfield;

    @FXML
    private HBox hbox;

    @FXML
    private Button a1;

    @FXML
    private TabPane tabpane;

    @FXML
    private Tab newTab;


    private final String HttP = "http://";

    private double zoom = 1;

    WebEngine webEngine;

    WebHistory history;

    ObservableList<WebHistory.Entry> entries;


    int counter = 1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        webEngine = webView.getEngine();
        webView.setZoom(zoom);
        searchTextfield.setText("www.google.com");
        webEngine.load(HttP + "www.google.com");

    }


    @FXML
    void newTab(Event event) {

        if (tabpane.getTabs().size() == 1) {
            Stage stage = (Stage) tabpane.getScene().getWindow();
            stage.close();
        }
        Tab tab = new Tab("tab_" + (counter + 1));
        try {
            Parent root = FXMLLoader.load(getClass().getResource("borderpane.fxml"));
            tab.setContent(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
        tabpane.getTabs().add(tabpane.getTabs().size() - 1, tab);
        tabpane.setTabMaxWidth(150);
        tabpane.setTabMinWidth(80);
        tabpane.getSelectionModel().select(tabpane.getTabs().size() - 2);
//        webEngine=webView.getEngine();
//        webView.setZoom(zoom);
        searchTextfield.setText("www.google.com");
        webEngine.load(HttP + "www.google.com");


        counter++;
    }

    @FXML
    void search(ActionEvent event) {
        webEngine.load(HttP + searchTextfield.getText().toString());


    }

    @FXML
    void reload(ActionEvent event) {
        webEngine.reload();
    }

    @FXML
    void ZoomIn(ActionEvent event) {
        zoom = +0.25;
        webView.setZoom(zoom);
    }

    @FXML
    void ZoomOut(ActionEvent event) {
        zoom = -0.25;
        webView.setZoom(zoom);
    }

    @FXML
    void getHistory(ActionEvent event) {

        history = webEngine.getHistory();
        entries = history.getEntries();

        for (WebHistory.Entry entry : entries) {
            System.out.println(entry.getTitle() + "   " + entry.getLastVisitedDate());

        }

    }

    @FXML
    void Back(ActionEvent event) {

        history.go(-1);
        searchTextfield.setText(entries.get(history.getCurrentIndex()).getUrl());

    }

    @FXML
    void Forward(ActionEvent event) {
        history.go(1);
        searchTextfield.setText(entries.get(history.getCurrentIndex()).getUrl());
    }


}
