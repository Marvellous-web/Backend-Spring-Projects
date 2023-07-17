package com.stackroute.Jpa.TrackList.controller;

import com.stackroute.Jpa.TrackList.model.Track;
import com.stackroute.Jpa.TrackList.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TrackController {
    @Autowired
    private TrackService trackService;

    //http://localhost:1111/getAllTrack     [GET]
    @GetMapping("/getAllTrack")
    public ResponseEntity<?> getAllTrack(){
        return new ResponseEntity<>(trackService.getAllTrack(), HttpStatus.OK);
    }

    //http://localhost:1111/addTrack        [POST]
    @PostMapping("/addTrack")
    public ResponseEntity<?> addTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.addTrack(track),HttpStatus.OK);
    }

    //http://localhost:1111/delete-track=by-id/{trackId}    [DELETE]
    @DeleteMapping("/delete-track=by-id/{trackId}")
    public ResponseEntity<?> deleteTrack(@PathVariable String trackId){
        return new ResponseEntity<>(trackService.deleteTrack(trackId),HttpStatus.OK);
    }

    //http://localhost:1111/updateTrack     [UPDATE]
    @PutMapping("/updateTrack")
    public ResponseEntity<?> updateTrack(@RequestBody Track track){
        return new ResponseEntity<>(trackService.updateTrack(track),HttpStatus.OK);
    }

    //http://localhost:1111/get-track-by-id/{trackId}       [GET]
    @GetMapping("/get-track-by-id/{trackId}")
    public ResponseEntity<?> getTrackById(@PathVariable String trackId){
        return new ResponseEntity<>(trackService.getTrackById(trackId),HttpStatus.OK);
    }

    //http://localhost:1111/get-track-by-artist/{artist}       [GET]
    @GetMapping("/get-track-by-artist/{artist}")
    public ResponseEntity<?> getTrackByArtist(@PathVariable String artist){
        return new ResponseEntity<>(trackService.getTrackByArtist(artist),HttpStatus.OK);
    }
}
