package sample.cuphead.controller;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import sample.cuphead.model.Boss;
import sample.cuphead.model.Bullet;
import sample.cuphead.model.Game;

import java.util.ArrayList;

public class GameController implements Runnable{
    Game game = Game.getInstance();
    Boss boss = Boss.getInstance(null);
    private ImageView plane;
    private Label score;
    private Label cupHeadHp;
    private Label enemeyHp;
    private AnchorPane anchorPane;
    public GameController(ImageView plane , Label score , Label cupHeadHp , Label enemeyHp , AnchorPane anchorPane) {
        this.plane = plane;
        this.cupHeadHp = cupHeadHp;
        this.enemeyHp = enemeyHp;
        this.score = score;
        this.anchorPane = anchorPane;
    }
    @Override
    public void run() {
        while (game.getHealth() > 0 && boss.getHp() > 0) {
            Bullet.getBullets();
            ArrayList<Bullet> bullets = new ArrayList<>(Bullet.getBullets());
            for (Bullet bullet : bullets) {
                if (boss.hasCollision(bullet)) {
                    bullet.getBulletAnimation().stop();
                    bullet.remove();
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Shooting.fadeHandling(boss);
                            anchorPane.getChildren().remove(bullet);
                            game.setScore(game.getScore() + 5);
                            boss.setHp(boss.getHp() - game.getShootPower());
                            Shooting.updateTabBar(game , boss , score , enemeyHp);
                        }
                    });
                    break;
                }
            }
        }
    }
}
