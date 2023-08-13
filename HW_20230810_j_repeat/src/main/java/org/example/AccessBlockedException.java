package org.example;

public class AccessBlockedException extends RuntimeException{
    @Override
    public String getMessage(){
        return "User access blocked.";
    }
}
