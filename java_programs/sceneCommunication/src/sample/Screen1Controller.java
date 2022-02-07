package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen1Controller {

    @FXML
    TextField namescreen1;
    @FXML
    TextField mobilescreen1;
    @FXML
    TextField emailscreen1;

    public void screen2window(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("screen2.fxml"));
        Parent root = loader.load();
        Screen2Controller sc2controller = loader.getController();
        sc2controller.Show(namescreen1.getText(), mobilescreen1.getText(), emailscreen1.getText());
        Stage stage = new Stage();
        stage.setTitle("screen2");
        stage.setScene(new Scene(root, 500, 400));

        stage.show();


    }

    public void screen3window(ActionEvent e) throws Exception {
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("screen3.fxml"));
            Parent root = loader.load();
            Screen3Controller sc3controller = loader.getController();
            sc3controller.Show(namescreen1.getText(), mobilescreen1.getText(), emailscreen1.getText());

            Stage stage = new Stage();
            stage.setTitle("screen3");
            stage.setScene(new Scene(root, 500, 400));

            stage.show();
        }
    }

    public void Show(String name, String mobile, String Email) {
        namescreen1.setText(name);
        mobilescreen1.setText(mobile);
        emailscreen1.setText(Email);

    }
}
