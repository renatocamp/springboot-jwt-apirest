package com.gateways.renato.springbootjwt.exceptions;

public class NoUserException extends RuntimeException{

    public NoUserException(Integer message){
        super("User not found " + message);
    }
}
