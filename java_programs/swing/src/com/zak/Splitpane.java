package com.zak;

import javax.swing.*;
import java.awt.*;

public class Splitpane extends JFrame {


    public Splitpane() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        JButton b1 = new JButton("Left");
        JButton b2 = new JButton("Right");
        sp.setTopComponent(b1);
        sp.setBottomComponent(b2);

        sp.setOneTouchExpandable(true);
        sp.setDividerLocation(200);
        sp.setDividerSize(10);

        add(sp);


        setVisible(true);
    }

    public static void main(String[] args) {
        new Splitpane();
    }
}
