package sample.cuphead.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Plane {
    private static Plane instance;
    public static Plane getInstance(){
        if (instance == null) instance = new Plane();
        return instance;
    }
    private Image image;
    private Plane(){
    }

}
