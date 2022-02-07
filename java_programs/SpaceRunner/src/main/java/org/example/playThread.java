package org.example;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


class playThread extends Thread {


    private Pane pane;

    playThread(Pane pane) {
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

//     System.out.println("Done....");
        timer.cancel();

    }

    public void createObstacles() {
        Random rand = new Random();
        int random = rand.nextInt(561);
        Image astroid = new Image("/org/example/33623-5-asteroid-photos-thumb.png");
        ImageView astro = new ImageView(astroid);
        astro.setX(random);
        astro.setY(-50);
        astro.setFitWidth(50);
        astro.setFitHeight(50);
        pane.getChildren().addAll(astro);

        TranslateTransition trns = new TranslateTransition(Duration.millis(2000), astro);
        trns.setCycleCount(1);
        trns.setToY(415);
        trns.play();


    }


}
