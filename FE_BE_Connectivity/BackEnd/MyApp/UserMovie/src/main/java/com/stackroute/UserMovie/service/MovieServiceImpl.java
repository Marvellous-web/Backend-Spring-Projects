package com.stackroute.UserMovie.service;

import com.stackroute.UserMovie.model.Movie;
import com.stackroute.UserMovie.respository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public boolean movieDeleteById(String id) {
        movieRepository.deleteById(id);

        return true;
    }

    @Override
    public Movie updateMovieDetails(Movie movie) {
        return movieRepository.save(movie);
    }
}
