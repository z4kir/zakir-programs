package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen2Controller {
    @FXML
    TextField namescreen2;
    @FXML
    TextField mobilescreen2;
    @FXML
    TextField emailscreen2;

    public void screen1window(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("screen1.fxml"));
        Parent root = loader.load();
        Screen1Controller sc1controller = loader.getController();
        sc1controller.Show(namescreen2.getText(), mobilescreen2.getText(), emailscreen2.getText());
        Stage stage = new Stage();
        stage.setTitle("screen1");
        stage.setScene(new Scene(root, 500, 400));

        stage.show();


    }

    public void screen3window(ActionEvent e) throws Exception {
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("screen3.fxml"));
            Parent root = loader.load();
            Screen3Controller sc3controller = loader.getController();
            sc3controller.Show(namescreen2.getText(), mobilescreen2.getText(), emailscreen2.getText());

            Stage stage = new Stage();
            stage.setTitle("screen3");
            stage.setScene(new Scene(root, 500, 400));

            stage.show();
        }
    }

    public void Show(String name, String mobile, String Email) {
        namescreen2.setText(name);
        mobilescreen2.setText(mobile);
        emailscreen2.setText(Email);

    }
}
