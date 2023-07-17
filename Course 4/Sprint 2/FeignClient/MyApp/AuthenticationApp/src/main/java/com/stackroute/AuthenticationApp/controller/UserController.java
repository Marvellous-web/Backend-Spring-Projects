package com.stackroute.AuthenticationApp.controller;

import com.stackroute.AuthenticationApp.exception.UserAlreadyExistException;
import com.stackroute.AuthenticationApp.feignClient.SignUpData;
import com.stackroute.AuthenticationApp.model.User;
import com.stackroute.AuthenticationApp.respository.UserRepository;
import com.stackroute.AuthenticationApp.service.SecurityTokenGenerator;
import com.stackroute.AuthenticationApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController @RequestMapping("/authenticationApp")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/authenticationApp/addUser
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) throws UserAlreadyExistException
    {
        try {
            user.setRole("Engineer");
            return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyExistException ex)
        {
            ex.printStackTrace();
            throw new UserAlreadyExistException();
        }


    }
    //http://localhost:8080/authenticationApp/signupUser
    @PostMapping("/signupUser")
    public ResponseEntity<?> SignupUser(@RequestBody SignUpData signUpData) throws UserAlreadyExistException
    {
        return new ResponseEntity<>(userService.signupUser(signUpData),HttpStatus.OK);
    }
    @PostMapping("/loginCheck")
    public ResponseEntity<?> loginCheck(@RequestBody User user){
        User user1=userService.loginCheck(user.getEmailId(),user.getPassword());
        System.out.println(user1);
        if(user1!=null)
        {
            user1.setPassword("");
            return new ResponseEntity<>(user1,HttpStatus.OK);
        }
        else return new ResponseEntity<>("Login Failed",HttpStatus.OK);

    }
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;
    @PostMapping("/authenticate")
    public ResponseEntity<?> loginCheck1(@RequestBody User user)
    {
        User result=userService.loginCheck(user.getEmailId(),user.getPassword());
        if(result!=null)
        {
//            Map<String,String> key=securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(securityTokenGenerator.generateToken(result),HttpStatus.OK);
        }
        else return new ResponseEntity<>("Authentication Failed",HttpStatus.NOT_FOUND);
    }
}
