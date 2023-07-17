package com.stackroute.UserMovie.respository;

import com.stackroute.UserMovie.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMovieRepository extends MongoRepository<User,String> {
}
