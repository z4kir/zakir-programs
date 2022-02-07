package org.example;

import javafx.animation.AnimationTimer;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class PrimaryController {

    @FXML
    private ImageView rect1;

    @FXML
    private Button btn;
    @FXML
    private Pane pane;

    @FXML
    private ImageView backgroundimg1;

    @FXML
    private ImageView backgroundimg3;

    @FXML
    private ImageView backgroundimg2;

    private int count = 1;

    private boolean isLeftKeyispressed;
    private boolean isRightKeyispressed;
    private AnimationTimer gameanimation;


    public void initialize() {


    }


    public void play() {
        new playThread(pane).start();
        setBackgroundimg();
        creategameloop();
    }

    public void setImage(int n, int count) {
        System.out.println("count check1= " + count);

        switch (n) {

            case 1:
                if (count == 1) {


                    Image image = new Image(("/org/example/28670-3-galaxy-photo-thumb.png"));
                    backgroundimg1.setImage(image);


                }
                if (count == 2) {

                    Image image = new Image("/org/example/28884-8-galaxy-photos-thumb.png");
                    backgroundimg1.setImage(image);
                }
                if (count == 3) {

                    Image image = new Image("org/example/32940-4-moon-image-thumb.png");
                    backgroundimg1.setImage(image);
                }
                break;

            case 2:
                Image image = new Image("org/example/28884-8-galaxy-photos-thumb.png");
                backgroundimg1.setImage(image);
                break;

            case 3:
                Image imag = new Image("org/example/32940-4-moon-image-thumb.png");
                backgroundimg1.setImage(imag);
                break;


        }


    }

    public void setBackgroundimg() {


        if (count > 3) {
            count = 1;
        }

        TranslateTransition T1 = new TranslateTransition(Duration.seconds(2));
        T1.setNode(backgroundimg1);
        T1.setToY(pane.getHeight());
        T1.setCycleCount(1);
        T1.play();
        T1.setOnFinished(event -> {

            backgroundimg1.setTranslateY(-backgroundimg1.getTranslateY());
            setImage(1, count);


        });


        TranslateTransition T2 = new TranslateTransition(Duration.seconds(603f / 200f));
        T2.setNode(backgroundimg2);

        T2.setToY(pane.getHeight() - backgroundimg2.getLayoutY());
        T2.setCycleCount(1);
        T2.play();

        T2.setOnFinished(event -> {

            backgroundimg2.setTranslateY(-backgroundimg2.getTranslateY());
            setImage(2, count);
            count++;
            setBackgroundimg();
        });


        TranslateTransition T3 = new TranslateTransition(Duration.seconds(507f / 200f));
        T3.setNode(backgroundimg3);

        T3.setToY(pane.getHeight() - backgroundimg3.getLayoutY());
        T3.setCycleCount(1);
        T3.play();
        T3.setOnFinished(event -> {

            backgroundimg3.setTranslateY(-backgroundimg3.getTranslateY());
            setImage(3, count);


        });

    }

    public void createCircleBullet() {
        Image bullet = new Image("/org/example/bullet.jpg");
        ImageView bulletView = new ImageView(bullet);
        bulletView.setX(rect1.getX() + 28);
        bulletView.setY(rect1.getLayoutY());
        bulletView.setFitHeight(17);
        bulletView.setFitWidth(12);
        pane.getChildren().addAll(bulletView);

        TranslateTransition trns = new TranslateTransition(Duration.millis(500), bulletView);
        trns.setCycleCount(1);
        trns.setToY(-415);
        trns.play();
        trns.setOnFinished(e -> bulletView.setImage(null));

    }


    @FXML
    void btn(KeyEvent event) {


        switch (event.getCode()) {

            case S:
                play();

                break;


            case RIGHT:
                isRightKeyispressed = true;
                break;


            case LEFT:
                isLeftKeyispressed = true;
                break;
            case SPACE:
                if (rect1.getRotate() == 0) {
                    createCircleBullet();
                }
                break;

        }

    }

    @FXML
    void release(KeyEvent event) {
        switch (event.getCode()) {
            case RIGHT:
                isRightKeyispressed = false;
                break;
            case LEFT:
                isLeftKeyispressed = false;
                break;
        }


    }

    public void creategameloop() {
        gameanimation = new AnimationTimer() {
            @Override
            public void handle(long l) {
                move();
            }
        };
        gameanimation.start();
    }

    public void move() {
        if (isLeftKeyispressed && !isRightKeyispressed) {
            if (rect1.getX() > 0) {
                rect1.setX(rect1.getX() - 3);
                if (rect1.getRotate() > -30) {
                    rect1.setRotate(-30);
                }

            }

        }
        if (!isLeftKeyispressed && isRightKeyispressed) {


            if (rect1.getX() + 50 < 600) {
                rect1.setX(rect1.getX() + 3);
                if (rect1.getRotate() < 30) {
                    rect1.setRotate(30);
                }
            }

        }
        if (isLeftKeyispressed && isRightKeyispressed) {


            rect1.setX(rect1.getX());
            rect1.setRotate(0);

        }
        if (!isLeftKeyispressed && !isRightKeyispressed) {


            rect1.setX(rect1.getX());
            rect1.setRotate(0);
        }
    }


}
//    @FXML
//    void move(KeyEvent event) {
//
//            System.out.println("ri.....");
//            switch (event.getCode()){
//                case P:
//                    System.out.println("hey.....");
//                    break;
//
//                case RIGHT:
//                    if (rect1.getX()+50 < 600 ) {
//                        System.out.println("right.....");
//                        TranslateTransition rect1T=new TranslateTransition(Duration.seconds(2),rect1);
//                        rect1T.setToX(rect1.getX() + 20);
//                        rect1T.play();
////                    rect1.setX(rect1.getX()+20);
//                    }
//                    break;
//
//
//                case L:
//                    if (rect1.getX() > 0) {
//                        System.out.println("left.....");
//                        TranslateTransition rect1T=new TranslateTransition(Duration.seconds(2),rect1);
//                        rect1T.setToX(rect1.getX() - 20);
//                        rect1T.play();
//                    }
//                    break;
//
//            }
//
//
//
//    }
