package com.zak;

import javax.swing.*;
import java.awt.*;

public class Progressbar extends JFrame {
    public Progressbar() {
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());
        JProgressBar pb = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
        add(pb);
        pb.setStringPainted(true);
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i < 50) {
                pb.setString("please wait for sometime");
            }
            if (i > 50 && i < 100) {
                pb.setString("about to complete");
            }
            if (i == 100) {
                pb.setString("Finished");
            }

            pb.setValue(i);

        }

    }

    public static void main(String[] args) {
        new Progressbar();
    }
}
