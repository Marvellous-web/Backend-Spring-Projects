package com.stackroute.MovieCrud.service;

import com.stackroute.MovieCrud.model.Movie;
import com.stackroute.MovieCrud.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> getMovies() {
        return (List<Movie>) movieRepository.findAll();
        //select * from movie
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }
}
