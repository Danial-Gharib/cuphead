package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import sample.cuphead.App;
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
        int frame = (int) Math.floor(v * 8);
        bullet.setLayoutX(bullet.getLayoutX() + 10);
        if (bullet.getLayoutX() >= 1000){
            bullet.getAnchorPane().getChildren().remove(bullet);
            this.stop();
            bullet.remove();
        }
        bullet.setBackground("/sample/cuphead/assets/img/Plane/Mini/Bullet/" + frame + ".png");
    }
}
