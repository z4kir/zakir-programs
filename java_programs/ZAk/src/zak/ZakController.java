/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zak;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Skin;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *
 * @author Fearless
 */
public class ZakController implements Initializable {

    @FXML
    private TextField tf;
    @FXML
    private ColorPicker colorchoser;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void close(ActionEvent event) {
        System.out.println("yo I am Quiting");


    }
}
