package com.zak;

import javax.swing.*;
import java.awt.*;

public class Spinner extends JFrame {
    JSpinner spin, spin2;
    JLabel label;

    public Spinner() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        String Str[] = {"as", "df", "se"};
        SpinnerModel sm = new SpinnerListModel(Str);
        spin = new JSpinner(sm);
        add(spin);
        SpinnerModel sm2 = new SpinnerDateModel();
        spin2 = new JSpinner(sm2);
        add(spin2);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Spinner();

    }
}
