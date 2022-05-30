package sample.cuphead;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.stage.WindowEvent;
import sample.cuphead.controller.UserController;
import sample.cuphead.model.Game;
import sample.cuphead.model.User;
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
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                userController.getUser().setScore(Game.getInstance().getScore());
                userController.saveUsers();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

    public static Scene getScene() {
        return scene;
    }
}