package com.zak.animation;

import javax.swing.*;
import java.awt.*;

public class AnimationPanel extends JPanel {
    int x = 0;
    int y = 0;
    int Y_step = 5;
    int X_step = 5;
    final int ballwidth = 50;
    final int ballheight = 50;
    final int max_x = 600 - ballwidth;
    final int max_Y = 800 - ballheight;

    public AnimationPanel() {
        this.setPreferredSize(new Dimension(600, 800));
        this.setBackground(Color.BLACK);


    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, ballwidth, ballheight);
        if (x > max_x || x < 0)
            X_step = -X_step;
        if (y > max_Y || y < 0)
            Y_step = -Y_step;

        x = x + X_step;
        y = y + Y_step;

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
