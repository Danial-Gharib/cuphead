package sample.cuphead.model;

public class User implements Comparable<User>{
    private String username;
    private String password;
    private int score;
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.score = 0;
    }

    @Override
    public int compareTo(User o) {
        if (this.getScore() != o.getScore()) return o.getScore() - this.getScore();
        return this.getUsername().compareTo(o.getUsername());
    }
}
