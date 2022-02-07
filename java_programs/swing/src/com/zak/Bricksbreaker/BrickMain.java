package com.zak.Bricksbreaker;

import javax.swing.*;

public class BrickMain {
    public static void main(String[] args) {
        JFrame bricksFrame = new JFrame();
        bricksFrame.setLocationRelativeTo(null);
        bricksFrame.setTitle("Bricks_Breaker");
        bricksFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        bricksFrame.setResizable(false);
        bricksFrame.add(new bricksPanel());
        bricksFrame.setVisible(true);
        bricksFrame.pack();
    }
}
