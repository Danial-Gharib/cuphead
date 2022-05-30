package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.util.Duration;
import sample.cuphead.model.MiniBoss;

public class MiniBossAnimation extends Transition {
    private MiniBoss miniBoss;
    public MiniBossAnimation(MiniBoss miniBoss) {
        this.miniBoss = miniBoss;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
    }

    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 15);
        miniBoss.setLayoutX(miniBoss.getLayoutX() - 5);
        miniBoss.setBackground("/sample/cuphead/assets/img/Phase 1/Flappy Birds/Yellow/Fly/" + frame + ".png");
    }
}
