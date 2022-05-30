package sample.cuphead.model;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.cuphead.transition.MiniBossAnimation;

import java.util.ArrayList;

public class MiniBoss extends Rectangle {
    private static ArrayList<MiniBoss> miniBosses = new ArrayList<>();
    private AnchorPane anchorPane;
    private MiniBossAnimation miniBossAnimation;

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public MiniBossAnimation getMiniBossAnimation() {
        return miniBossAnimation;
    }

    public void setMiniBossAnimation(MiniBossAnimation miniBossAnimation) {
        this.miniBossAnimation = miniBossAnimation;
    }
    public static ArrayList<MiniBoss> getMiniBosses() {
        return miniBosses;
    }
    public void remove() {miniBosses.remove(this);}
    public void setBackground(String url) {
        this.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
    }

    public MiniBoss(double x , double y , AnchorPane anchorPane) {
        super(x , y , 110 , 110);
        this.anchorPane = anchorPane;
        miniBosses.add(this);
    }
}
