package sample.cuphead.view;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import sample.cuphead.App;
import sample.cuphead.controller.GameController;
import sample.cuphead.controller.PlaneMovement;
import sample.cuphead.controller.UserController;
import sample.cuphead.enumeraion.PlaneMovementFrames;
import sample.cuphead.model.Boss;
import sample.cuphead.model.Bullet;
import sample.cuphead.model.Game;
import sample.cuphead.model.User;
import sample.cuphead.transition.PlaneAnimation;
import sample.cuphead.transition.Timer;

public class GamePageController {
    public ImageView avatar;
    public Label username;
    public Label score;
    public Label enemyHp;
    public Label cupHeadHp;
    public ImageView plane;
    public AnchorPane pane;
    public AudioClip audioClip;
    public Text timer;

    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void initialize() {
        Boss boss = Boss.getInstance(pane);
        showTopBar();
        plane.setImage(new Image(App.class.getResource(PlaneMovementFrames.MOVE.getAddress() +  "0.png").toString()));
        PlaneAnimation planeAnimation = new PlaneAnimation(plane);
        planeAnimation.play();
        initializeSoundEffects();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.requestFocus();
            }
        });
        Thread gameLogic = new Thread(new GameController(plane , score , cupHeadHp , enemyHp  , pane));
        gameLogic.setDaemon(true);
        gameLogic.start();

    }

    private void initializeSoundEffects() {
        audioClip = new AudioClip(App.class.getResource("/sample/cuphead/assets/music/shutgun.mp3").toString());
    }


    public void showTopBar() {
        UserController userController = UserController.getInstance();
        User user = userController.getUser();
        String hey = user.getUsername();
        username.setText(hey);
        String sc = Integer.toString(user.getScore());
        score.setText(sc);
        avatar.setImage(new Image(user.getAvatar()));
        Game game = Game.getInstance();
        Boss boss = Boss.getInstance(null);
        enemyHp.setText(Integer.toString(boss.getHp()));
        cupHeadHp.setText(Integer.toString(game.getHealth()));
        Timer myTimer = new Timer(timer);
        myTimer.play();
    }

    public void movement(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case W: {
                PlaneMovement.moveUp(plane);
                break;
            }
            case S: {
                PlaneMovement.moveDown(plane);
                break;
            }
            case D: {
                PlaneMovement.moveRight(plane);
                break;
            }
            case A: {
                PlaneMovement.moveLeft(plane);
                break;
            }
            case SPACE: {
                fire();
                break;
            }
        }
    }

    private void fire() {
        Bullet bullet = new Bullet(plane.getLayoutX() + 95 , plane.getLayoutY() + 40 , pane);
        pane.getChildren().add(bullet);
        bullet.setVisible(true);
        audioClip.play();
    }

    public void grayScale(MouseEvent mouseEvent) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(-1);
        if (pane.getEffect() != null) {
            pane.setEffect(null);
        }
        else {
            pane.setEffect(colorAdjust);
        }
        pane.requestFocus();
    }
}
