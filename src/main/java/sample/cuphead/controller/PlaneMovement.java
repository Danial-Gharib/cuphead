package sample.cuphead.controller;

import javafx.scene.image.ImageView;

public class PlaneMovement {

    public static void moveUp(ImageView plane) {
        if (plane.getLayoutY() <= 55) return;
        plane.setLayoutY(plane.getLayoutY() - 10);
    }

    public static void moveDown(ImageView plane) {
        if (plane.getLayoutY() >= 620) return;
        plane.setLayoutY(plane.getLayoutY() + 10);
    }

    public static void moveLeft(ImageView plane) {
        if (plane.getLayoutX() <= 0 ) return;
        plane.setLayoutX(plane.getLayoutX() - 10);
    }

    public static void moveRight(ImageView plane) {
        if (plane.getLayoutX() >= 1070) return;
        plane.setLayoutX(plane.getLayoutX() + 10);
    }
}
