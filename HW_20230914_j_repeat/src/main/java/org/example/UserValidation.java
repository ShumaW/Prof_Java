package org.example;

public class UserValidation {
    public boolean validateUsername(String username) {
        return username.length() >= 6 && username.length() <= 20 && username.matches("^\\w+$");
    }

    public boolean validateEmail(String email) {
        return email.length() >= 6 && email.length() <= 50 && email.contains("@");
    }
}
