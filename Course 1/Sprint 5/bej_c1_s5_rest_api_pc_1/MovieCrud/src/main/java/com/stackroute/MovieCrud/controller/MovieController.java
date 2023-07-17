package com.stackroute.MovieCrud.controller;

import com.stackroute.MovieCrud.model.Movie;
import com.stackroute.MovieCrud.repository.MovieRepository;
import com.stackroute.MovieCrud.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;


    //http://localhost:9999/getMovies       [GET]
    @GetMapping("/getMovies")
    public ResponseEntity<?> getMovies(){

        return new ResponseEntity<>(movieService.getMovies(), HttpStatus.OK);
    }

    //http://localhost:9999/addMovies       [POST]
    @PostMapping("/addMovies")
    public ResponseEntity<?> addMovies(@RequestBody Movie movie){
        return new ResponseEntity<>(movieService.addMovie(movie),HttpStatus.OK);
    }


}
