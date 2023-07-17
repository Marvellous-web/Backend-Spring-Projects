package com.example.MySqlDemo.controller;

import com.example.MySqlDemo.model.Song;
import com.example.MySqlDemo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {
    @Autowired
    private SongService songService;
    //http://localhost:8085\addSong
    @PostMapping("/addSong")
    public ResponseEntity<?> addSong(@RequestBody  Song song)
    {
        return new ResponseEntity<>(songService.addSong(song), HttpStatus.OK);
    }
    @GetMapping("/getAllByArist/{artist}")
    public ResponseEntity<?> getSongsByArtist(@PathVariable String artist)
    {
        return new ResponseEntity<>(songService.getSongsByArtist(artist),HttpStatus.OK);
    }
    @GetMapping("/getSongsByRating/{rating}")
    public ResponseEntity<?> getSongsByRating(@PathVariable int rating)
    {
        return new ResponseEntity<>(songService.getSongsByRating(rating),HttpStatus.OK);
    }
    @GetMapping("/getSongByRatingAndArtist/{rating}/{artist}")
    public ResponseEntity<?> getSongByRatingAndArtist(@PathVariable int rating,@PathVariable String artist)
    {
        return new ResponseEntity<>(songService.getSongByRatingAndArtist(rating, artist),HttpStatus.OK);
    }


}
