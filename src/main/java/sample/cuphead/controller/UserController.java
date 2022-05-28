package sample.cuphead.controller;

import sample.cuphead.App;
import sample.cuphead.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    private static UserController instance;
    public static UserController getInstance() {
        if (instance == null) instance = new UserController();
        return instance;
    }
    private UserController() {
        this.users = new ArrayList<>();
    }
    private  ArrayList<User> users;
    private User user;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public  ArrayList<User> getUsers() {
        return users;
    }
    public void loadUsers() {
        try {
            ArrayList<User> loadUsers = new ArrayList<>();
            String json = new String(Files.readAllBytes(Paths.get(this.getClass().getResource("/sample/cuphead/database/Database.json").toURI())));
            loadUsers = new Gson().fromJson(json , new TypeToken<List<User>>(){}.getType());
            if (loadUsers != null) users = loadUsers;
        }
        catch (IOException | URISyntaxException e){
            e.printStackTrace();
        }
    }
    public void saveUsers()  {
        try {
            FileWriter fileWriter = new FileWriter("D:/SUT/Term2/AP/Assignments/Cuphead/src/main/resources/sample/cuphead/database/Database.json");
            fileWriter.write(new Gson().toJson(users));
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String login(String username, String password) {
        for (User user1 : users) {
            if (user1.getUsername().equals(username) && user1.getPassword().equals(password)) {
                this.user = user1;
                return "success";
            }
        }
        return "error";
    }

    public String register(String username, String password) {
        for (User user1 : users) {
            if (user1.getUsername().equals(username)) return "a user with this username exists!";
        }
        if (password.length() <= 3) return "password is weak!";
        User user = new User(username , password);
        this.user = user;
        users.add(user);
        return "success!";
    }
    public void removeUser() {
        users.remove(user);
        user = null;
    }
}
