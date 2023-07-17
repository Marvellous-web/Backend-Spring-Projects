package com.stackroute.UserMovie.service;

import com.stackroute.UserMovie.exception.UserAlreadyExistException;
import com.stackroute.UserMovie.model.Movie;
import com.stackroute.UserMovie.model.User;
import com.stackroute.UserMovie.respository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieServiceImpl implements UserMovieService{
    @Autowired
    private UserMovieRepository userMovieRepository;
    @Override
    public User addUser(User user) throws UserAlreadyExistException {
        if(userMovieRepository.findById(user.getEmailId()).isPresent())
        {
            throw new UserAlreadyExistException();
        }

        return userMovieRepository.insert(user) ;
    }

    @Override
    public List<User> getALlUser() {
        return userMovieRepository.findAll();
    }

    @Override
    public User getUserByEmail(String emailId) {


        return  userMovieRepository.findById(emailId).get();
    }

    @Override
    public User addMovieByEmail( Movie movie,String email) {
        User user1=userMovieRepository.findById(email).get();
        user1.getMovieList().add(movie);


        return userMovieRepository.save(user1);
    }
}
