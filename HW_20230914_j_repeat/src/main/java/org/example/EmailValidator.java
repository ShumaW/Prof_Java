package org.example;

public class EmailValidator {
    public static boolean isValidateEmail(String email) {
     String emailRegex = "^\\w+@(.+)$";

    return email.matches(emailRegex);
    }
}
