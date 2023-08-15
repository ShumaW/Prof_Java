package org.example.exceptions;

public class NotFoundPasswordException extends RuntimeException{
    @Override
    public String getMessage(){
        return "Wrong password entered. Please enter correct password.";
    }
}
