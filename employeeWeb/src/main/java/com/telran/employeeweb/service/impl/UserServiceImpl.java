package com.telran.employeeweb.service.impl;

import com.telran.employeeweb.model.entity.Employee;
import com.telran.employeeweb.model.entity.User;
import com.telran.employeeweb.repository.UserRepository;
import com.telran.employeeweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getUser(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public List<User> findByUsernameOrEmail(String name, String email){
        return userRepository.findByUsernameOrEmail(name,email);
    }

    @Override
    public Page<User> findAllByRole(String role, Pageable pageable) {
        return userRepository.findAllByRole(role,pageable);
    }

    @Override
    public User addOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.getById(id);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUserNameAndRole(String id, String username, String role) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            user.setUsername(username);
            user.setRole(role);
            return userRepository.save(user);
        }
        return null;
    }

}
