package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen3Controller {
    @FXML
    TextField namescreen3;
    @FXML
    TextField mobilescreen3;
    @FXML
    TextField emailscreen3;

    public void screen1window(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("screen1.fxml"));
        Parent root = loader.load();
        Screen1Controller sc1controller = loader.getController();
        sc1controller.Show(namescreen3.getText(), mobilescreen3.getText(), emailscreen3.getText());
        Stage stage = new Stage();
        stage.setTitle("screen1");
        stage.setScene(new Scene(root, 500, 400));

        stage.show();


    }

    public void screen2window(ActionEvent e) throws Exception {
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("screen2.fxml"));
            Parent root = loader.load();
            Screen2Controller sc2controller = loader.getController();
            sc2controller.Show(namescreen3.getText(), mobilescreen3.getText(), emailscreen3.getText());

            Stage stage = new Stage();
            stage.setTitle("screen2");
            stage.setScene(new Scene(root, 500, 400));

            stage.show();
        }
    }

    public void Show(String name, String mobile, String Email) {
        namescreen3.setText(name);
        mobilescreen3.setText(mobile);
        emailscreen3.setText(Email);

    }
}
