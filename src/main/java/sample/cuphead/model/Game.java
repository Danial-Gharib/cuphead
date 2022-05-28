package sample.cuphead.model;

public class Game {
    private static Game instance;
    public static Game getInstance(){
        if (instance == null) instance = new Game();
        return instance;
    }
    private int health;
    private int damage;
    private int shootPower;

    public Game() {
        this.health = 5;
        this.damage = 2;
        this.shootPower = 2;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getShootPower() {
        return shootPower;
    }

    public void setShootPower(int shootPower) {
        this.shootPower = shootPower;
    }
}
