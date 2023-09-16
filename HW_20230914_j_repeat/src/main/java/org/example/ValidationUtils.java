package org.example;

public class ValidationUtils {

    public boolean isEmailValid(String email) {
        String emailRegex = "^\\w+@(?:\\w+\\.)+\\w{2,}$";
        return email.matches(emailRegex);
    }

    public boolean isPhoneNumberValid(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("\\ |\\-", "");
        String regex = "\\+\\d*";

        if (digitsOnly.length() < 10) {
            return false;
        }

        if (!digitsOnly.startsWith("+1")) {
            return false;
        }

        return digitsOnly.matches(regex);
    }

    public boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (password.contains(" ")) {
            return false;
        }

        if (!password.matches("\\w+\\D+")) {
            return false;
        }

        return true;
    }
}
