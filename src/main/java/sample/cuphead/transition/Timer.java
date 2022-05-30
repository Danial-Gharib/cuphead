package sample.cuphead.transition;

import javafx.animation.Transition;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.text.DecimalFormat;

public class Timer extends Transition {
    private Text text;
    private long firstTime;
    public Timer(Text text) {
        this.text = text;
        this.setCycleCount(-1);
        this.setCycleDuration(Duration.millis(500));
        this.firstTime = System.currentTimeMillis();
    }
    @Override
    protected void interpolate(double v) {
        long minute = (System.currentTimeMillis() - firstTime) / 1000;
        minute /= 60;
        long seceonds = (System.currentTimeMillis() - firstTime) / 1000;
        seceonds %= 60;
        DecimalFormat decimalFormat = new DecimalFormat("00");
        text.setText(decimalFormat.format(minute) + ":" + decimalFormat.format(seceonds));
    }
}
