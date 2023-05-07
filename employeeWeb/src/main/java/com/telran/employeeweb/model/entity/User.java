package com.telran.employeeweb.model.entity;

/**
 * Добавить в проект employeeWeb (см. код в репозитории) новое Entity - класс User с полями:
 * <p>
 * public class User {
 * private String id;
 * private String username;
 * private String password;
 * private String role;
 * private String email;
 * }
 * <p>
 * Этот класс будет отвечать за зарегистрированных пользователей Web-приложения
 * Добавить соответствующие классы по всем слоям MVC-архитектуры:
 * UserRepository,
 * UserService,
 * UserServiceImpl,
 * UserController,
 * UserRestController,
 * users.jsp,
 * user.jsp
 * <p>
 * UserRepository:
 * имитация работы с БД
 * public class UserRepository {
 * private List users = new ArrayList<>();
 * public UserRepository() {
 * users.addAll(Arrays.asList(
 * new User(UUID.randomUUID().toString(), "admin", "123", "ROLEADMIN", "111@gmail.com"),
 * new User(UUID.randomUUID().toString(), "editor1", "123", "ROLEUSER", "222@gmail.com"),
 * new User(UUID.randomUUID().toString(), "editor2", "123", "ROLE_USER", "333@gmail.com")
 * ));
 * }
 * public List getAll(){
 * return users;
 * }
 * public User getById(String id) {
 * return users.stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
 * }
 * }
 * <p>
 * UserRestController:
 * <p>
 * по url /usersRest должен выдать список всех пользователей в JSON
 * <p>
 * умеет добавлять, редактировать, удалять пользователя
 * <p>
 * UserController:
 * <p>
 * по url /users должен выдать список всех пользователей, список отображается через файл users.jsp
 * <p>
 * по url /users/id должен выдать пользователя с данным id, пользователь отображается через файл user.jsp
 * <p>
 * Протестировать работу классов через браузер, Postman.
 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "employeewebuser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "email")
    private String email;

    @Column(name = "additional_info")
    private String additionalInfo;
}
