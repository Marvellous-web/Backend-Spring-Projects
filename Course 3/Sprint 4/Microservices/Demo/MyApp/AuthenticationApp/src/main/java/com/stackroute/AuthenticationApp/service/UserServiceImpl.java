package com.stackroute.AuthenticationApp.service;

import com.stackroute.AuthenticationApp.exception.UserAlreadyExistException;
import com.stackroute.AuthenticationApp.model.User;
import com.stackroute.AuthenticationApp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
//    @Autowired
//    private User user;
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) throws UserAlreadyExistException {
//       if(userRepository.findById())
        if(userRepository.findById(user.getEmailId()).isPresent())
        {
            throw new UserAlreadyExistException();
        }
        return userRepository.save(user);
    }

    @Override
    public User loginCheck(String id, String password) {
        return userRepository.findBEmailIdAndPassword(id, password);
    }
}
