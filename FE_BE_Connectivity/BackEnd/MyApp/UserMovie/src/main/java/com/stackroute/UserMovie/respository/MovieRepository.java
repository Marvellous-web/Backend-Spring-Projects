package com.stackroute.UserMovie.respository;

import com.stackroute.UserMovie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
