package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
    @FXML
    private Label status;
    @FXML
    private TextField username_txt;
    @FXML
    private PasswordField password_txt;

    @FXML
    private TextField username_set;

    @FXML
    private TextField password_set;
    @FXML
    private Button submit;


    Stage stage3 = new Stage();
    ;
    Main m = new Main();

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    String UserName;
    String Password;


    public void login(ActionEvent e) throws Exception {
        if (username_txt.getText().equals(UserName) && password_txt.getText().equals(Password)) {


            status.setText("Login Successful");
            Stage stage2 = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            stage2.setTitle("Login information");
            stage2.setScene(new Scene(root, 500, 500));
            System.out.println(UserName + "\n" + Password);
            stage2.show();
            m.stage.hide();


        } else {
            status.setText("Login Failed");
            System.out.println(UserName + "\n" + Password);

        }

    }

    public void creat_ID(ActionEvent e) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Set.fxml"));
        stage3.setTitle("Login information");
        stage3.setScene(new Scene(root, 300, 275));
        stage3.show();


        if (e.getSource().equals(submit)) {

        }
    }

    public void set(ActionEvent e) {
        setUserName(username_set.getText());
        setPassword(password_set.getText());
        System.out.println(UserName);
        username_set.setText("");
        password_set.setText("");
        stage3.hide();

    }


}





