package Task3;

import java.util.List;

public class UserService {
    private UserRepository repository;

    public static void main(String[] args) {

        /*
        В классе UserService (см. код занятия в репозитории) реализовать
        метод public void deleteInactive(List users),
        который будет удалять с помощью метода UserRepository deleteUser(int id)
        из БД всех неактивных пользователей из списка.
        Составить тест на данный метод с применением Mockito.
         */


    }

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean isActive(int id) {
        User user = repository.getUserById(id);
        return user.isActive();
    }

    public void deactivate(int id) {
        User user = repository.getUserById(id);
        user.setActive(false);
        repository.saveUser(user);
    }

    public void deleteInactive(List<User> users){
        for (User user : users) {
            if (!user.isActive()){
                repository.deleteUser(user.getId());
            }
        }
    }
}
