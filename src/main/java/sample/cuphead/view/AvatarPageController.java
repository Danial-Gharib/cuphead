package sample.cuphead.view;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.controller.UserController;

import java.util.Random;


public class AvatarPageController {

    public ImageView av1;
    public ImageView av2;
    public ImageView av3;
    public ImageView av4;
    public ImageView av5;
    public ImageView av6;
    UserController userController = UserController.getInstance();

    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void choose() {
        userController.saveUsers();
        MenuControl.changeMenu("mainPage");
    }

    public void choose1(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av1.getImage().getUrl());
        choose();
    }

    public void choose2(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av2.getImage().getUrl());
        choose();
    }

    public void choose3(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av3.getImage().getUrl());
        choose();
    }

    public void choose4(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av4.getImage().getUrl());
        choose();
    }
    public void choose5(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av5.getImage().getUrl());
        choose();
    }
    public void choose6(MouseEvent mouseEvent) {
        userController.getUser().setAvatar(av6.getImage().getUrl());
        choose();
    }

    public void random(MouseEvent mouseEvent) {
        Random random = new Random();
        int randomNumber = random.nextInt();
        switch (randomNumber % 6) {
            case 0 : {choose1(null); break;}
            case 1 : {choose2(null); break;}
            case 2 : {choose3(null); break;}
            case 3 : {choose4(null); break;}
            case 4 : {choose5(null); break;}
            case 5 : {choose6(null); break;}
        }
    }
}
