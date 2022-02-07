package com.zak.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationFrame extends JFrame {
    AnimationFrame() {
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(new AnimationPanel());
        this.pack();
    }
}
