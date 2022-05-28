package sample.cuphead.view;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class ScoreBoardController {
    public void mute(MouseEvent mouseEvent) {
        MediaPlayer mediaPlayer = MenuControl.getMediaPlayer();
        mediaPlayer.setMute(!mediaPlayer.isMute());
    }

}
