package com.webcrudapi.service;

public class UserNotFoundExcemtion extends Throwable {
    public UserNotFoundExcemtion(String message) {
        super(message);
    }
}
