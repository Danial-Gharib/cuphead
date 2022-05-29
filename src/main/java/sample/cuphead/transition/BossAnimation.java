package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import sample.cuphead.model.Boss;

public class BossAnimation extends Transition {
    private Boss boss;
    public BossAnimation(Boss boss) {
        this.boss = boss;
        this.setCycleDuration(Duration.millis(750));
        this.setCycleCount(-1);
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 5);
        boss.setBackground("/sample/cuphead/assets/img/BossFly/" + frame + ".png");
    }
}
