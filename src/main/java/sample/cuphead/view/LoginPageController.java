package sample.cuphead.view;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sample.cuphead.App;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.User;

public class LoginPageController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void login(MouseEvent mouseEvent) {
        UserController userController = UserController.getInstance();
        String result = userController.login(username.getText() , password.getText());
        if (result.startsWith("error")) {
            showError("username and password don't match!");
        }
        else MenuControl.changeMenu("mainPage");
    }

    public void playAsGuest(MouseEvent mouseEvent) {
        UserController userController = UserController.getInstance();
        User user = new User("guest" , "guest");
        user.setAvatar("file:/D:/SUT/Term2/AP/Assignments/Cuphead/target/classes/sample/cuphead/assets/img/AvatarMenu/guest.png");
        userController.setUser(user);
        MenuControl.getMediaPlayer().stop();
        MenuControl.playMenuMusic("game");
        MenuControl.changeMenu("gamePage");
    }

    public void register(MouseEvent mouseEvent) {
        UserController userController = UserController.getInstance();
        String result = userController.register(username.getText() , password.getText());
        if (result.startsWith("a user")) {
            showError(result);
        }
        else if (result.startsWith("password is weak")) {
            showError(result);
        }
        else MenuControl.changeMenu("avatarPage");
    }
    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }
}
