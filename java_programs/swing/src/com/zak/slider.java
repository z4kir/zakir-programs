package com.zak;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class slider extends JFrame {
    JSlider slider;
    JLabel label;

    public slider() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        slider = new JSlider();
        add(slider);
        slider.setMaximum(200);
        slider.setMinimum(0);

        slider.setPaintTicks(true);
        slider.setPaintLabels(true);

        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(5);

        label = new JLabel();
        label.setText("The Value of slider :" + slider.getValue());
        add(label);

        validate();

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label.setText("The Value of slider :" + slider.getValue());

            }
        });


    }

    public static void main(String[] args) {
        new slider();
    }
}
