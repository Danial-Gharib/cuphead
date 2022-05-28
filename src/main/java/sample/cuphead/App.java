package sample.cuphead;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import sample.cuphead.controller.UserController;
import sample.cuphead.model.Game;
import sample.cuphead.view.MenuControl;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Game game = Game.getInstance();
        UserController userController = UserController.getInstance();
        userController.loadUsers();
        Parent root = MenuControl.loadFXML("loginPage");
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CupHead");
        stage.setResizable(false);
        stage.show();
        MenuControl.playMenuMusic("namehraboone");
    }

    public static void main(String[] args) {
        launch();
    }

    public static Scene getScene() {
        return scene;
    }
}