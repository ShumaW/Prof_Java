package org.example.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;
@Getter
@AllArgsConstructor
public class UserDatabase {

    public static final List<User> users = new ArrayList<>();

    public static List<User> getUserById(int id) {
        if (id > users.size()){
            throw new NullPointerException();
        }
        return users.stream()
                .filter(user -> user.getId() == id)
                .toList();
    }

    public static List<User> getUserByUsername(String username) {
        List<String> names = users.stream().map(User::getUserName).toList();
        if (!names.contains(username)){
            throw new IllegalArgumentException();
        }
        return users.stream()
                .filter(user -> user.getUserName().equals(username))
                .toList();
    }

    public static void addUser(User user) {
        if (user == null){
            throw new NullPointerException();
        }
        users.add(user);
    }

    @Override
    public String toString() {
        return "UserDatabase: " + " \n" + users;
    }
}
