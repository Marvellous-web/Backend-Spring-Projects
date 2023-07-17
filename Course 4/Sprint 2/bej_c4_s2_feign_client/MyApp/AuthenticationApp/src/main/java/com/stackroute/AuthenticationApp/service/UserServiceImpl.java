package com.stackroute.AuthenticationApp.service;

import com.stackroute.AuthenticationApp.exception.UserAlreadyExistException;
import com.stackroute.AuthenticationApp.feignClient.SignUpData;
import com.stackroute.AuthenticationApp.feignClient.UserDto;
import com.stackroute.AuthenticationApp.feignClient.UserProxy;
import com.stackroute.AuthenticationApp.model.User;
import com.stackroute.AuthenticationApp.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    private UserProxy userProxy;

    @Override
    public User loginCheck(String id, String password) {
        return userRepository.findBEmailIdAndPassword(id, password);
    }

    @Override
    public User addUser1(SignUpData signUpData) throws UserAlreadyExistException {
        UserDto userDto=new UserDto(signUpData.getEmailId(),signUpData.getName(), signUpData.getAddress());
        ResponseEntity responseEntity=userProxy.sendUserDataToProductApp(userDto);
        User user=new User(signUpData.getEmailId(), signUpData.getPassword(), "Role_User");
        System.out.println(responseEntity);
        return userRepository.save(user);
    }
}
