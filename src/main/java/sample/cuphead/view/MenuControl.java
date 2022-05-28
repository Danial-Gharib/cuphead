package sample.cuphead.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import sample.cuphead.App;

import java.io.IOException;
import java.net.URL;

public class MenuControl {

    private static MediaPlayer mediaPlayer;

    public static Parent loadFXML(String menuName) {
        URL address = null;
        try {
            address = new URL(App.class.getResource("/sample/cuphead/fxml/" + menuName + ".fxml").toExternalForm());
            return FXMLLoader.load(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void changeMenu(String menuName) {
        Parent root = loadFXML(menuName);
        App.getScene().setRoot(root);
    }

    public static void playMenuMusic(String music) {
        Media media = new Media(App.class.getResource("/sample/cuphead/assets/music/" + music + ".mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
}
