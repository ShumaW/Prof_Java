package com.telran.employeeweb.model.entity;

/**
 * Добавить в проект employeeWeb (см. код в репозитории) новое Entity - класс User с полями:
 *
 * public class User {
 *     private String id;
 *     private String username;
 *     private String password;
 *     private String role;
 *     private String email;
 * }
 *
 * Этот класс будет отвечать за зарегистрированных пользователей Web-приложения
 * Добавить соответствующие классы по всем слоям MVC-архитектуры:
 * UserRepository,
 * UserService,
 * UserServiceImpl,
 * UserController,
 * UserRestController,
 * users.jsp,
 * user.jsp
 *
 * UserRepository:
 * имитация работы с БД
 * public class UserRepository {
 *     private List users = new ArrayList<>();
 *     public UserRepository() {
 *         users.addAll(Arrays.asList(
 *                 new User(UUID.randomUUID().toString(), "admin", "123", "ROLEADMIN", "111@gmail.com"),
 *                 new User(UUID.randomUUID().toString(), "editor1", "123", "ROLEUSER", "222@gmail.com"),
 *                 new User(UUID.randomUUID().toString(), "editor2", "123", "ROLE_USER", "333@gmail.com")
 *         ));
 *     }
 *     public List getAll(){
 *         return users;
 *     }
 *     public User getById(String id) {
 *         return users.stream().filter(e -> e.getId().equals(id)).findAny().orElse(null);
 *     }
 * }
 *
 * UserRestController:
 *
 * по url /usersRest должен выдать список всех пользователей в JSON
 *
 * умеет добавлять, редактировать, удалять пользователя
 *
 * UserController:
 *
 * по url /users должен выдать список всех пользователей, список отображается через файл users.jsp
 *
 * по url /users/id должен выдать пользователя с данным id, пользователь отображается через файл user.jsp
 *
 * Протестировать работу классов через браузер, Postman.
 */

public class User {

    private String id;
    private String username;
    private String password;
    private String role;
    private String email;

    public User(String id, String username, String password, String role, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
