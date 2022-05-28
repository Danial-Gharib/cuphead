package sample.cuphead.view;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import sample.cuphead.model.Game;

public class SettingPageController {
    public Game game = Game.getInstance();
    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

    public void easy(MouseEvent mouseEvent) {
        game.setShootPower(10);
        game.setDamage(1);
        game.setHealth(10);
        MenuControl.changeMenu("mainPage");
    }

    public void medium(MouseEvent mouseEvent) {
        game.setShootPower(5);
        game.setDamage(2);
        game.setHealth(5);
        MenuControl.changeMenu("mainPage");
    }

    public void hard(MouseEvent mouseEvent) {
        game.setShootPower(3);
        game.setDamage(3);
        game.setHealth(2);
        MenuControl.changeMenu("mainPage");
    }
}
