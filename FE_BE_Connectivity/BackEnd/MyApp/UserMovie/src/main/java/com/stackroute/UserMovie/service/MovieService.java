package com.stackroute.UserMovie.service;

import com.stackroute.UserMovie.model.Movie;

import java.util.List;

public interface MovieService {

    public abstract List<Movie> getAllMovie();
    public abstract Movie addMovie(Movie movie);
    public abstract boolean movieDeleteById(String id);
    public abstract Movie updateMovieDetails(Movie movie);


}
