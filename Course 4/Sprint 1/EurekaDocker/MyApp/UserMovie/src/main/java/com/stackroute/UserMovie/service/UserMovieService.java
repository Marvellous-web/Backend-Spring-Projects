package com.stackroute.UserMovie.service;

import com.stackroute.UserMovie.exception.UserAlreadyExistException;
import com.stackroute.UserMovie.model.Movie;
import com.stackroute.UserMovie.model.User;
import com.stackroute.UserMovie.respository.UserMovieRepository;

import java.util.List;

public interface UserMovieService {
    public abstract User addUser(User user) throws UserAlreadyExistException;
    public abstract List<User> getALlUser();
    public abstract User getUserByEmail(String emailId);
    public abstract User addMovieByEmail(Movie movie,String email);

}
