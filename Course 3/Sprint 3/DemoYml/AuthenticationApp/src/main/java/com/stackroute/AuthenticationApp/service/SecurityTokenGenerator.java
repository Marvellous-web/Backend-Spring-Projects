package com.stackroute.AuthenticationApp.service;

import com.stackroute.AuthenticationApp.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    public abstract Map<String,String> generateToken(User user);


}
