package com.zak;

import javax.swing.*;
import java.awt.*;

public class Tooltip extends JFrame {


    public Tooltip() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel label = new JLabel("Password :");
        label.setBounds(10, 20, 80, 20);
        JPasswordField pw = new JPasswordField();
        pw.setBounds(100, 20, 200, 20);
        pw.getAccessibleContext();
        String s = "<html>"
                + "<div bgcolor='red' color='white'>"
                + "Enter your password<br/>"
                + "Password shoud contains"
                + "</div>"
                + "</html>";

        pw.setToolTipText(s);
        add(label);
        add(pw);


        setVisible(true);

    }

    public static void main(String[] args) {
        new Tooltip();
    }
}
