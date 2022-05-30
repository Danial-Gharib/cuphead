package sample.cuphead.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.AnchorPane;
import sample.cuphead.model.MiniBoss;
import sample.cuphead.transition.MiniBossAnimation;

public class MiniBossCreation implements Runnable{
    private AnchorPane anchorPane;
    private long firstTime;
    public MiniBossCreation(AnchorPane anchorPane , long firstTime) {
        this.anchorPane = anchorPane;
        this.firstTime = firstTime;
    }
    @Override
    public void run() {
        while (true) {
            if(System.currentTimeMillis() - firstTime >= 7000) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 3; i++) {
                            MiniBoss miniBoss = new MiniBoss(1200 + 200 * i , 150 , anchorPane);
                            anchorPane.getChildren().add(miniBoss);
                            MiniBossAnimation miniBossAnimation = new MiniBossAnimation(miniBoss);
                            miniBossAnimation.play();
                        }
                    }
                });
                firstTime = System.currentTimeMillis();
            }
        }
    }
}
