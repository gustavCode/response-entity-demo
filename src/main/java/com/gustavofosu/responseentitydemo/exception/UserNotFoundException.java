package com.gustavofosu.responseentitydemo.exception;

/*
    Created by Gustav on 2/18/2025
    @author : Gustav Ofosu
    @date : 2/18/2025
    @project : response-entity-demo
*/

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
