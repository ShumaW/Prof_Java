package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private int id;
    private String userName;
    private String password;
    private boolean access;
    private String email;
    final List<Role> roles = new ArrayList<>();

    public User(int id, String userName, String password, boolean access, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.access = access;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User: " + id +
                ", userName: " + userName +
                ", email: " + email +
                ", roles: " + roles +
                ", access: " + access + "\n";
    }

    public String getUserInfo(){
        return id + " " + userName + " " + email + " " + roles + " " + access + "\n";
    }

    public void addRole(Role role) {
        if (role == null){
            throw new NullPointerException();
        }
        roles.add(role);
    }

    public void removeRole(Role role) {
        roles.remove(role);
    }

    public void setAccess(boolean access) {
        this.access = access;
    }
}
