package com.zak.swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class frame extends JFrame implements ActionListener {
    JButton b;
    JLabel l;
    JTextField tf;

    frame() {
        this.setTitle("first_frame");
        this.setSize(400, 400);
        GridBagLayout gb = new GridBagLayout();

        this.setLayout(gb);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // g.setHgap(30);
        // g.setVgap(20);
        GridBagConstraints gbc = new GridBagConstraints();

        tf = new JTextField("my name is zakir");
        b = new JButton("Click");
        l = new JLabel("befor");

        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(tf, gbc);


        gbc.weightx = 0;
        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(b, gbc);


        // tf.setBounds(50, 50, 200, 20);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.BELOW_BASELINE_LEADING;
        this.add(l, gbc);

        b.addActionListener(this);


        // b.setBounds(120, 100, 70, 30);

        // l.setBounds(100, 150, 200, 30);

        // this.add(tf);
        // this.add(b);
        // this.add(l);

        pack();

        this.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Click")) {
            l.setText(tf.getText());
            tf.setText("");

        }

    }

    public static void main(String[] args) {
        new frame();

    }

}
