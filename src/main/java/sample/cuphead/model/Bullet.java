package sample.cuphead.model;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.cuphead.transition.BulletAnimation;

import java.util.ArrayList;

public class Bullet extends Rectangle {
    private static ArrayList<Bullet> bullets = new ArrayList<>();
    private AnchorPane anchorPane;
    private BulletAnimation bulletAnimation;

    public BulletAnimation getBulletAnimation() {
        return bulletAnimation;
    }

    public void setBulletAnimation(BulletAnimation bulletAnimation) {
        this.bulletAnimation = bulletAnimation;
    }

    public Bullet(double x , double y , AnchorPane anchorPane) {
        super(x , y , 100 , 30);
        this.anchorPane = anchorPane;
        bullets.add(this);
        bulletAnimation = new BulletAnimation(this);
        bulletAnimation.play();
        this.anchorPane.getChildren().add(this);
    }

    public static ArrayList<Bullet> getBullets() {
        return bullets;
    }
    public void remove() {bullets.remove(this);}
    public void setBackground(String url) {
        this.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }
}
