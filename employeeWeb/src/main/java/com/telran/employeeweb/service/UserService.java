package com.telran.employeeweb.service;

import com.telran.employeeweb.model.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUser();

    void add(User user);

    boolean updateUser(User user);

    void deleteUser(String id);

    List<User> getUsers();

    User getUserById(String id);
}
