package org.example;

import static org.example.UserDatabase.getUserByUsername;

public class AuthenticationService {

    public AuthenticationService() {
    }

    public String authenticate(String username, String password) {
        if (getUserByUsername(username).isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("User is not found. Access is blocked!");
        } else if (!getUserByUsername(username).get(0).isAccess()) {
            throw new AccessBlockedException();
        } else if (!getUserByUsername(username).get(0).getPassword().equals(password)) {
            throw new NotFoundPasswordException();
        }
        return "Access is open!";
    }

    public void grantAccess(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        getUserByUsername(user.getUserName()).get(0).setAccess(true);
    }

    public void revokeAccess(User user) {
        if (user == null) {
            throw new NullPointerException();
        }
        getUserByUsername(user.getUserName()).get(0).setAccess(false);
    }
}
