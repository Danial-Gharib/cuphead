package sample.cuphead.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.User;

import java.util.ArrayList;

public class ScoreBoardController {
    public TableView<User> scoreboard;
    public TableColumn<User , String> usernameCol;
    public TableColumn<User , Integer> scoreCol;

    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void back(MouseEvent mouseEvent) {
        MenuControl.changeMenu("mainPage");
    }

    public void initialize(){
        usernameCol.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<User , Integer>("score"));
        UserController userController = UserController.getInstance();
        ArrayList<User> users = userController.getUsers();
        users.sort(User::compareTo);
        ObservableList<User> users1 = FXCollections.observableArrayList();
        users1.addAll(users);
        scoreboard.setItems(users1);
    }

}
