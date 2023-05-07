package com.telran.employeeweb.service;

import com.telran.employeeweb.model.entity.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUser();
    List<User> findByUsernameOrEmail(String name, String email);

    Page<User> findAllByRole(String role, Pageable pageable);

    User addOrUpdate(User user);

    void deleteUser(String id);

    User getUserById(String id);

    Optional<User> findById(String id);

    Page<User> getUser(Pageable pageable);

    User updateUserNameAndRole(String id, String username, String role);
}
