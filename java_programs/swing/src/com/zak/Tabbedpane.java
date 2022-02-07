package com.zak;

import javax.swing.*;
import java.awt.*;

public class Tabbedpane extends JFrame {

    public Tabbedpane() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTabbedPane tp = new JTabbedPane();

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.add(new JLabel("This is First"));
        panel2.add(new JLabel("This is Second"));
        panel3.add(new JLabel("This is Third"));

        tp.add("First", panel1);
        tp.add("Second", panel2);
        tp.add("Third", panel3);

        add(tp, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tabbedpane();
    }
}
