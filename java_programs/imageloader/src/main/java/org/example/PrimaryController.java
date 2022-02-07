package org.example;

import javafx.animation.Animation;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableBooleanValue;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;

public class PrimaryController {

    @FXML
    private ImageView rect1;

    @FXML
    private ImageView rect2;

    @FXML
    private AnchorPane pane;

    private int count = 1;

    private Image ship;


    private Image image;

    public void initialize() {
        System.out.println("bonds befor= " + rect1.getBoundsInParent());

        TranslateTransition t1 = new TranslateTransition(Duration.seconds(5), rect1);
        t1.setToY(pane.getPrefHeight() + rect1.getFitHeight());
        t1.setAutoReverse(true);
        t1.setCycleCount(Animation.INDEFINITE);
        t1.play();
        t1.setOnFinished(e -> System.out.println("bonds After= " + rect1.getBoundsInParent()));

//        TranslateTransition ti1=new TranslateTransition(Duration.seconds(3),imageView);
//        ti1.setToY(pane.getPrefHeight()+rect1.getHeight());
//        ti1.play();
        System.out.println("before= " + rect2.getY());


        TranslateTransition t2 = new TranslateTransition(Duration.seconds(5), rect2);
        t2.setToY(-pane.getPrefHeight() - rect2.getFitHeight());
        t2.setAutoReverse(true);
        t2.setCycleCount(Animation.INDEFINITE);
        t2.play();
        ImageView imageView = new ImageView();


        ObservableBooleanValue collide = Bindings.createBooleanBinding(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return rect1.getBoundsInParent().intersects(rect2.getBoundsInParent());
            }
        }, rect1.boundsInParentProperty(), rect2.boundsInParentProperty());
        collide.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean newValue) {
                if (newValue) {
                    System.out.println("Intersect....");
                    if (count == 1) {
                        rect1.setImage(null);
                        rect2.setImage(null);
                        ImageView blast = new ImageView();
                        blast.setY(200);
                        blast.setX(50);
                        blast.setFitHeight(100);
                        blast.setFitWidth(100);
                        blast.setImage(new Image("/org/example/—Pngtree—explosion_561406.png"));
//                        ScaleTransition s=new ScaleTransition(Duration.seconds(2),blast);
//                        s.setToY(100);
//                        s.setToX(100);
//                        s.setCycleCount(1);
//                        s.play();

                        t1.stop();
                        t2.stop();


                    }
//                    else{
//                        if (count==2){
//                            rect1.setFill(Color.CYAN);
//                            rect2.setFill(Color.CYAN);
//                            count=1;
//                        }
//
//                    }


                }
            }
        });


//        TranslateTransition ti2=new TranslateTransition(Duration.seconds(3),imageView2);
//        ti2.setToY(-pane.getPrefHeight()-rect2.getHeight());
//        ti2.play();


    }


    @FXML
    void getHeight(ActionEvent event) {
        new playThread(pane).start();

    }

}
