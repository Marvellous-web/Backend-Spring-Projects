package com.stackroute.Mongo.MusicApp.controller;

import com.stackroute.Mongo.MusicApp.exception.TrackAlreadyExistException;
import com.stackroute.Mongo.MusicApp.exception.TrackNotFoundException;
import com.stackroute.Mongo.MusicApp.model.Track;
import com.stackroute.Mongo.MusicApp.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackController {
    @Autowired
    private TrackService trackService;

    //http://localhost:3333/addTrack
    @PostMapping("/addTrack")
    public ResponseEntity<?> addTrack(@RequestBody Track track)throws TrackAlreadyExistException{
        try {
            return new ResponseEntity<>(trackService.addTrack(track), HttpStatus.OK);
        } catch (TrackAlreadyExistException e) {
            throw new TrackAlreadyExistException();
        }
    }

    //http://localhost:3333/getTrack
    @GetMapping("/getTrack")
    public ResponseEntity<?> getTrack(){
        return new ResponseEntity<>(trackService.getAllTracks(),HttpStatus.OK);
    }

    //http://localhost:3333/delete-track-by-id/{trackId}        [DELETE]
    @DeleteMapping("/delete-track-by-id/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable String trackId)throws TrackNotFoundException{
        try{
            return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
        }catch (TrackNotFoundException ex){
            throw new TrackNotFoundException();
        }
    }

    //http://localhost:3333/get-track-by-artist/{artist}
    @GetMapping("/get-track-by-artist/{artist}")
    public ResponseEntity<?> getTrackByArtist(@PathVariable String artist)throws TrackNotFoundException{
        return new ResponseEntity<>(trackService.getTrackByArtist(artist),HttpStatus.OK);
    }

    //http://localhost:3333/get-track-by-rating/{rating}
    @GetMapping("/get-track-by-rating/{rating}")
    public ResponseEntity<?> getTrackByRating(@PathVariable String rating)throws TrackNotFoundException{
        return new ResponseEntity<>(trackService.getAllTrackByRating(rating),HttpStatus.OK);
    }

    @PutMapping("/updateTrack")
    public ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNotFoundException {
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }


}
