package com.telran.employeeweb.repository;

import com.telran.employeeweb.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByUsernameOrEmail(String name, String email);

    Page<User> findAllByRole(String role, Pageable pageable);


}
