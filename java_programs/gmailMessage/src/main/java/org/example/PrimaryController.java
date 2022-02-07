package org.example;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PrimaryController implements Initializable {


    @FXML
    private TextField from;

    @FXML
    private PasswordField pw;

    @FXML
    private TextField to;

    @FXML
    private TextField subject;

    @FXML
    private TextArea msg;

    @FXML
    private CheckBox show;

    @FXML
    private TextField showtext;

    class SendWithGivenTime extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(120000);
                setVariablesForGmail();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        SendWithGivenTime s = new SendWithGivenTime();
        s.start();


    }

    void setVariablesForGmail() {
//        Variable for gmail
        String host = "smtp.gmail.com";

//        get the system properties
        Properties properties = System.getProperties();

//        setting important information in properties
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

//        Step 1:to get the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from.getText(), pw.getText());
            }

        });
        session.setDebug(true);

//        step 2:compose the message [text,multi media]
        MimeMessage message = new MimeMessage(session);

        try {
//        from email
            message.setFrom(from.getText());

//            adding recipient to message
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to.getText()));

//            adding subject
            message.setSubject(subject.getText());

//            adding message(Text)
            message.setText(msg.getText());

//            step 3:send message by using transport class
            Transport.send(message);


        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void sendMessage(ActionEvent event) {
        setVariablesForGmail();
    }

    @FXML
    void setShowPassword(ActionEvent event) {
        if (show.isSelected()) {
            showtext.setText(pw.getText());
            pw.setVisible(false);
            showtext.setVisible(true);


        } else {
            pw.setText(showtext.getText());
            pw.setVisible(true);
            showtext.setVisible(false);
        }
    }

}
