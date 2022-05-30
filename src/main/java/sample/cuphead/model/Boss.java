package sample.cuphead.model;

import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sample.cuphead.transition.BossAnimation;

public class Boss extends Rectangle {
    private static Boss instance;
    private AnchorPane anchorPane;
    private BossAnimation bossAnimation;
    private int hp;
    public static Boss getInstance(AnchorPane anchorPane){
        if (instance == null) instance = new Boss(anchorPane);
        return instance;
    }

    public BossAnimation getBossAnimation() {
        return bossAnimation;
    }

    public void setBossAnimation(BossAnimation bossAnimation) {
        this.bossAnimation = bossAnimation;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    private Boss(AnchorPane anchorPane) {
        super(900 , 190 , 320 , 300);
        this.anchorPane = anchorPane;
        anchorPane.getChildren().add(this);
        this.setVisible(true);
        this.hp = 100;
        bossAnimation = new BossAnimation(this);
        bossAnimation.play();
    }
    public void setBackground(String url) {
        this.setFill(new ImagePattern(new Image(getClass().getResource(url).toExternalForm())));
    }
    public boolean hasCollision(Rectangle bullet) {
        return bullet.getBoundsInParent().intersects(this.getLayoutBounds());
    }
}
