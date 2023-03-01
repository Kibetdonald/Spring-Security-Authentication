package com.springauthentication.Implementing.Spring.Security.Exception;

public class UserNotFoundException extends RuntimeException  {
    public UserNotFoundException(Integer id){
        super("Could not find user with ID " +id);
    }
}