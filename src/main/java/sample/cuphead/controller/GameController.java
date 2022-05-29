package sample.cuphead.controller;

import sample.cuphead.model.Game;

public class GameController {
    private static GameController instance;
    public static GameController getInstance(){
        if (instance == null) instance = new GameController();
        return instance;
    }
    private Game game;
    private GameController(){
        this.game = Game.getInstance();
    }


}
