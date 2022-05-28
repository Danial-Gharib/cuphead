package sample.cuphead.view;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.User;

public class ProfilePageController {
    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void back(MouseEvent mouseEvent) {
        MenuControl.changeMenu("mainPage");
    }

    public void changeAvatar(MouseEvent mouseEvent) {
        MenuControl.changeMenu("avatarPage");
    }

    public void changePassword(MouseEvent mouseEvent) {
        MenuControl.changeMenu("changePassword");
    }

    public void changeUsername(MouseEvent mouseEvent) {
        MenuControl.changeMenu("changeUsername");
    }

    public void deleteAccount(MouseEvent mouseEvent) {
        UserController userController = UserController.getInstance();
        userController.removeUser();
        MenuControl.changeMenu("loginPage");
        userController.saveUsers();
    }
}
