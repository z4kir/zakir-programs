package org.example;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


class playThread extends Thread {


    private AnchorPane pane;

    playThread(AnchorPane pane) {
        this.pane = pane;
    }


    @Override
    public void run() {

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {

                    createObstacles();

                });
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 5000);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.cancel();

    }

    public void createObstacles() {
        Random rand = new Random();
        int random = rand.nextInt(586 - 25) + 25;
        Image astroid = new Image("/org/example/33623-5-asteroid-photos-thumb.png");
        ImageView astro = new ImageView(astroid);
        astro.setX(random);
        astro.setY(0);
        astro.setFitWidth(30);
        astro.setFitHeight(30);
        pane.getChildren().addAll(astro);


        TranslateTransition trns = new TranslateTransition(Duration.millis(2000), astro);
        trns.setCycleCount(1);
        trns.setToY(415);
        trns.play();


    }


}
