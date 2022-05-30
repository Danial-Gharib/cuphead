package sample.cuphead.controller;

import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;
import sample.cuphead.model.Boss;
import sample.cuphead.model.Game;

public class Shooting {
    public static void updateTabBar(Game game, Boss boss, Label score, Label enemeyHp) {
        score.setText(Integer.toString(game.getScore()));
        enemeyHp.setText(Integer.toString(boss.getHp()));
    }

    public static void fadeHandling(Boss boss) {
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(100) , boss);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        FadeTransition unfade = new FadeTransition(Duration.millis(100) , boss);
        unfade.setFromValue(0.0);
        unfade.setToValue(1.0);
        fadeTransition.play();
        unfade.play();
    }
}
