package com.zak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPane extends JFrame {
    JButton Click;
    JLabel label;


    public JOptionPane() {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.CENTER));

        Click = new JButton("Click");

        label = new JLabel();
        this.add(label);
        this.add(Click);
        Click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = javax.swing.JOptionPane.showInputDialog(JOptionPane.this, "First Name", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                if (javax.swing.JOptionPane.OK_OPTION == 0) {
                    label.setText(str);
                }
            }
        });


        setVisible(true);
    }

    public static void main(String[] args) {
        new JOptionPane();
    }
}
