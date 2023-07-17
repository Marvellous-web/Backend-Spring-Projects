package com.stackroute.UserMovie.controller;

import com.stackroute.UserMovie.model.Movie;
import com.stackroute.UserMovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController @RequestMapping("/adminMovie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAllMovie")
    public ResponseEntity<?> getAllMovie(){
        return new ResponseEntity<>(movieService.getAllMovie(), HttpStatus.OK);
    }

    @PostMapping("/addMovie")
    public ResponseEntity<?> addMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.addMovie(movie), HttpStatus.OK);
    }
    @PutMapping("/updateMovie")
    public ResponseEntity<?> updateMovie(@RequestBody Movie movie) {
        return new ResponseEntity<>(movieService.updateMovieDetails(movie), HttpStatus.OK);
    }
    @DeleteMapping("/deleteMovieById/{id}")
    public ResponseEntity<?> deleteMovieById(@RequestParam String id){
        return new ResponseEntity<>(movieService.movieDeleteById(id),HttpStatus.OK);
    }

}
