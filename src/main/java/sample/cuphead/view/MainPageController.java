package sample.cuphead.view;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.App;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.User;

public class MainPageController {


    public ImageView avatar;
    public Label username;

    public void initialize() {
        UserController userController = UserController.getInstance();
        User user = userController.getUser();
        String hey = user.getUsername();
        username.setText(hey);
        avatar.setImage(new Image(user.getAvatar()));
    }

    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void exit(MouseEvent mouseEvent) {
        MenuControl.changeMenu("loginPage");
    }

    public void scoreBoard(MouseEvent mouseEvent) {MenuControl.changeMenu("scoreboardPage");}

    public void setting(MouseEvent mouseEvent) {
        MenuControl.changeMenu("settingPage");
    }

    public void profileMenu(MouseEvent mouseEvent) {
        MenuControl.changeMenu("profilePage");
    }

    public void playGame(MouseEvent mouseEvent) {
        MenuControl.getMediaPlayer().stop();
        MenuControl.playMenuMusic("game");
        MenuControl.changeMenu("gamePage");
    }
}
