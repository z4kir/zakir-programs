package com.zak;

import javax.swing.*;
import java.awt.*;

public class Jscrollpane extends JFrame {

    public Jscrollpane() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTextArea tf = new JTextArea();
        JScrollPane sp = new JScrollPane(tf, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sp, BorderLayout.CENTER);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Jscrollpane();
    }

}
