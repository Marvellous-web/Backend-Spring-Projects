package com.stackroute.UserMovie.controller;

import com.stackroute.UserMovie.exception.UserAlreadyExistException;
import com.stackroute.UserMovie.model.Movie;
import com.stackroute.UserMovie.model.User;
import com.stackroute.UserMovie.service.UserMovieService;
import jdk.jfr.consumer.RecordedStackTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
public class UserMovieController {
    @Autowired
    private UserMovieService userMovieService;

    @PostMapping("/addUser")
    public ResponseEntity<?>  addUser(@RequestBody User user) throws UserAlreadyExistException
    {
        user.setMovieList(new ArrayList<Movie>());//for adding the movieList in the form of Array under the User
        return new ResponseEntity<>(userMovieService.addUser(user), HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<>(userMovieService.getALlUser(),HttpStatus.OK);
    }
    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> getUserByEmail(HttpServletRequest request){
        String currentUserId=(String) request.getAttribute("curr_user_email");
        return new ResponseEntity<>(userMovieService.getUserByEmail(currentUserId),HttpStatus.OK);

    }

    @PostMapping("/addMovieByEmail")
    public ResponseEntity<?> addMovieByEmail(@RequestBody Movie movie, HttpServletRequest request){

        String currentUserId=(String) request.getAttribute("curr_user_email");
        System.out.println(currentUserId);
        return new ResponseEntity<>(userMovieService.addMovieByEmail(movie,currentUserId),HttpStatus.OK);
    }


}
