package Task3;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public User getUserById(int id) {
        return new User(100, "Test", true);
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}

