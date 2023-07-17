package com.stackroute.MovieCrud.service;

import com.stackroute.MovieCrud.model.Movie;

import java.util.List;

public interface MovieService {
    public abstract List<Movie> getMovies();
    public abstract Movie addMovie(Movie movie);
}
