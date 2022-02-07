package com.zak.Bricksbreaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bricksPanel extends JPanel implements ActionListener, KeyListener {
    boolean play = false;
    int playerX = 300;
    final int Board_Width = 100;
    int ballx = 10;
    int bally = 400;
    int balldir_x = 10;
    int balldir_y = 10;
    Timer timer;
    int delay = 20;
    int gameover = -1;

    BlockMap bm;

    bricksPanel() {
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(700, 700));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        bm = new BlockMap();
        timer = new Timer(delay, this);
        timer.start();


    }

    public void paint(Graphics g) {

        super.paint(g);

        bm.draw((Graphics2D) g);
        g.setColor(Color.CYAN);
        g.fillRect(playerX, 690, Board_Width, 10);


        g.setColor(Color.orange);
        g.fillOval(ballx, bally, 30, 30);


        if (!play && gameover == -1) {
            gameStart(g);
        }
        if (!play && gameover == 1) {
            gameOver(g);
        }


    }

    public void ballMove() {
        if (play) {
            if (new Rectangle(playerX, 690, Board_Width, 10).intersects(new Rectangle(ballx, bally, 30, 30))) {
                balldir_y = -balldir_y;
            }
            ballx = ballx + balldir_x;
            bally = bally + balldir_y;
            if (ballx > 670 || ballx < 0) {
                balldir_x = -balldir_x;
            }
            if (bally < 0) {
                balldir_y = -balldir_y;
            }
            if (bally > 700) {
                play = false;
                gameover = 1;
            }


        }

    }

    public void gameStart(Graphics g) {

        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 45));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("press left or right to Start", 50, 700 / 2);


    }

    public void gameOver(Graphics g) {

        g.setColor(Color.WHITE);
        g.setFont(new Font("Ink Free", Font.BOLD, 40));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("Game Over", (700 - metrics.stringWidth("Game Over")) / 2, 700 / 2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        ballMove();
        repaint();


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX > 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX < 0) {
                playerX = 0;
            } else {
                moveLeft();
            }
        }
    }

    public void moveRight() {
        play = true;
        playerX += 20;

    }

    public void moveLeft() {
        play = true;
        playerX -= 20;

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
