package org.example.exceptions;

public class AccessBlockedException extends RuntimeException{
    @Override
    public String getMessage(){
        return "User access blocked.";
    }
}
