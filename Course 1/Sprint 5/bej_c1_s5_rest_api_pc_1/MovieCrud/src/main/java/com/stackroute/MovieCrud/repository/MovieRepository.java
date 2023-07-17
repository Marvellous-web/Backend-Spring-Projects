package com.stackroute.MovieCrud.repository;

import com.stackroute.MovieCrud.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie,String> {
}
