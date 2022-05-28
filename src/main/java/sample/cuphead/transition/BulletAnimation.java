package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import sample.cuphead.enumeraion.BulletFrames;
import sample.cuphead.model.Bullet;

import java.text.DecimalFormat;

public class BulletAnimation extends Transition {
    private Bullet bullet;
    public BulletAnimation(Bullet bullet) {
        this.bullet = bullet;
        this.setCycleDuration(Duration.millis(2000));
        this.setCycleCount(-1);
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 28);
        bullet.setLayoutX(bullet.getLayoutX() + 5);
        bullet.setBackground(BulletFrames.FIRE.getAddress() + new DecimalFormat("00").format(frame) + ".png");
    }
}
