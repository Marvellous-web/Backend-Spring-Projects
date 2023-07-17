package com.stackroute.AuthenticationApp.service;

import com.stackroute.AuthenticationApp.exception.UserAlreadyExistException;
import com.stackroute.AuthenticationApp.model.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public abstract User addUser(User user) throws UserAlreadyExistException;
    public abstract User loginCheck(String id,String password);


}
