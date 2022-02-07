package com.zak.Bricksbreaker;

import java.awt.*;

public class BlockMap {
    public int map[][];
    int blockwidth = 70;
    int blockheight = 50;
    int m = 0;
    int n = 0;

    BlockMap() {
        map = new int[4][8];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                map[i][j] = 1;

            }
        }
    }

    public void draw(Graphics2D g) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] > 0) {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * blockwidth + 35 + m, i * blockheight + 50 + n, blockwidth, blockheight);

                }
                m += 10;
            }
            n += 10;
        }

    }
}
//70(width)*8+10(Gap in between)*7+35(Gap with wall)
//50*4+10*3+50