package com.zak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class popupmenu extends JFrame {
    JPopupMenu pm;
    JMenuItem m1, m2, m3;
    JLabel label;

    public popupmenu() {
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        pm = new JPopupMenu();
        pm.setPopupSize(80, 100);
        m1 = new JMenuItem("Item1");
        m2 = new JMenuItem("Item2");
        m3 = new JMenuItem("Item3");

        label = new JLabel("before Selection");

        pm.add(m1);
        pm.add(m2);
        pm.add(m3);
        add(pm);
        add(label);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    pm.show(popupmenu.this, e.getX(), e.getY());
                }

            }
        });

        m1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("item1")) {
                    label.setText("this is item 1");
                }

            }
        });

        m2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("item2")) {
                    label.setText("this is item 2");
                }

            }
        });

        m3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equalsIgnoreCase("item3")) {
                    label.setText("this is item 3");
                }

            }
        });


//        pm.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if (e.getSource().toString().equalsIgnoreCase("item1")){
//                    label.setText("this is item 1");
//                }
//            }
//        });


        validate();


//


    }

    public static void main(String[] args) {
        new popupmenu();

    }
}
