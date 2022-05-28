package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import sample.cuphead.App;
import sample.cuphead.enumeraion.PlaneMovementFrames;

public class PlaneAnimation extends Transition {
    private ImageView imageView;
    public PlaneAnimation(ImageView imageView) {
        this.imageView = imageView;
        this.setCycleCount(-1);
        this.setAutoReverse(true);
        this.setCycleDuration(Duration.millis(800));
    }
    @Override
    protected void interpolate(double v) {
        int frame = (int) Math.floor(v * 11);
        imageView.setImage(new Image(App.class.getResource(PlaneMovementFrames.MOVE.getAddress() + frame + ".png").toString()));
    }
}