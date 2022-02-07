package sample;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Controller implements Initializable {

    @FXML
    private VBox vBox;

    @FXML
    private TextField sing_up_tf_Email;

    @FXML
    private TextField sing_in_tf_Email;

    @FXML
    private TextField sing_in_tf_Password;

    @FXML
    private TextField sing_up_tf_Password;
    @FXML
    private Label status;

    private Parent fxml;
    private Stage stage;
    private Scene scene;
    private String Email;


    @Override
    @SuppressWarnings("unchacked")
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
        t.setToX(-300);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });


    }

    @SuppressWarnings("unchacked")
    public void signIn(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);

        t.setToX(300);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

    }

    @SuppressWarnings("unchacked")
    public void signUp(ActionEvent event) {
        TranslateTransition t = new TranslateTransition(Duration.seconds(1), vBox);
        t.setToX(-300);
        t.play();
        t.setOnFinished((e) -> {
            try {
                fxml = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                vBox.getChildren().removeAll();
                vBox.getChildren().setAll(fxml);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

    }

    public void close(ActionEvent e) throws IOException {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.close();


    }

    public void minimize(ActionEvent e) throws IOException {
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setIconified(true);


    }

    public void signup(ActionEvent e) throws IOException {
        this.Email = sing_up_tf_Email.getText();


    }

    public void login(ActionEvent e) throws IOException {
        if (sing_in_tf_Email.getText().equals("zakir") && sing_in_tf_Password.getText().equals("zak123")) {
            status.setText("Login Successfull");
            fxml = FXMLLoader.load(getClass().getResource("login.fxml"));
            stage = new Stage();
            Scene scene = new Scene(fxml);
            scene.setFill(Color.TRANSPARENT);
            stage.setScene(scene);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } else {
            status.setText("Login Failed");

        }


    }


}
