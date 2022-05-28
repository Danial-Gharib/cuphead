package sample.cuphead.view;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.User;

public class ChangeUsernameAndPasswordController {

    public TextField username;
    public TextField newPassword;
    public TextField oldPassword;

    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void back(MouseEvent mouseEvent) {
        MenuControl.changeMenu("profilePage");
    }

    public void changeUsername(MouseEvent mouseEvent) {
        String newUsername = username.getText();
        UserController userController = UserController.getInstance();
        for (User user : userController.getUsers()) {
            if (user.getUsername().equals(newUsername)) {
                showError("a user with this username already exists!");
                return;
            }
        }
        if (newUsername.length() <= 3) {
            showError("invalid username type!");
            return;
        }
        User user = userController.getUser();
        user.setUsername(newUsername);
        MenuControl.changeMenu("profilePage");
    }
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    public void changePassword(MouseEvent mouseEvent) {
        String old = oldPassword.getText();
        String jadid = newPassword.getText();
        UserController userController = UserController.getInstance();
        User user = userController.getUser();
        if (jadid.equals(user.getPassword())) { showError("please enter a new password!"); return;}
        if (jadid.length() <= 3) {showError("password is weak!"); return;}
        if (!user.getPassword().equals(old)) {showError("password didn't match!"); return;}
        user.setPassword(jadid);
        MenuControl.changeMenu("profilePage");
    }
}
