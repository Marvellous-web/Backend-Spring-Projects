package com.stackroute.Mongo.MusicApp.repository;

import com.stackroute.Mongo.MusicApp.model.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TrackRepository extends MongoRepository<Track,String> {

    @Query("{'trackArtist.artistName' : {$in:[?0]}}")
    public abstract List<Track> getAllTrackByArtist(String artist);

    @Query("{'track.trackRating' : {$gte:[?0]}}")
    public abstract List<Track> getAllTrackByRating(String rating);
}
