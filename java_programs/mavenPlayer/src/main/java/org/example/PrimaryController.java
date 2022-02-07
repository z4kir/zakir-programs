package org.example;

import java.io.File;
import java.io.IOException;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class PrimaryController {

    @FXML
    private MediaView mediaview;

    @FXML
    private Slider progressbar;

    @FXML
    private Slider volumeslider;

    private int count = 1;

    private String path;

    private MediaPlayer mediaPlayer;

    public void choosefile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        path = file.toURI().toString();

        if (path != null) {
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaview.setMediaPlayer(mediaPlayer);

            DoubleProperty widthprop = mediaview.fitWidthProperty();
            DoubleProperty heightprop = mediaview.fitHeightProperty();

            widthprop.bind(Bindings.selectDouble(mediaview.sceneProperty(), "width"));
            heightprop.bind(Bindings.selectDouble(mediaview.sceneProperty(), "height"));


            mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                @Override
                public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration t1) {
                    progressbar.setValue(mediaPlayer.getCurrentTime().toSeconds());
                }
            });

            progressbar.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mediaPlayer.seek(Duration.seconds(progressbar.getValue()));
                }
            });

            progressbar.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    mediaPlayer.seek(Duration.seconds(progressbar.getValue()));
                }
            });

            mediaPlayer.setOnReady(new Runnable() {
                @Override
                public void run() {
                    progressbar.setMax(media.getDuration().toSeconds());
                }
            });

            //volume is between 0 to 1

            volumeslider.setValue(mediaPlayer.getVolume() * 100);
            volumeslider.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    mediaPlayer.setVolume(volumeslider.getValue() / 100);
                }
            });
            volumeslider.setMax(100);
            volumeslider.setMajorTickUnit(100 / 4);
            volumeslider.setShowTickLabels(true);
            volumeslider.setShowTickMarks(true);

            mediaPlayer.play();


        }

    }

    public void play(ActionEvent event) {
        mediaPlayer.play();
        mediaPlayer.setRate(1);

    }

    public void pause(ActionEvent event) {
        mediaPlayer.pause();
    }

    public void stop(ActionEvent event) {
        mediaPlayer.stop();
    }

    //normal rate is 1

    public void slowrate(ActionEvent event) {
        mediaPlayer.setRate(0.5);
    }

    public void fastforward(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    public void skip10(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
    }

    public void back10(ActionEvent event) {
        mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(-10)));
    }


    public void playandpause(KeyEvent event) {
        switch (event.getCode()) {
            case P:
                if (count == 1) {
                    mediaPlayer.pause();
                    count++;
                } else {
                    if (count == 2) {
                        mediaPlayer.play();
                        count = 1;
                    }
                }
                break;


        }


    }


}

