package com.stackroute.Mongo.MusicApp.service;

import com.stackroute.Mongo.MusicApp.exception.TrackAlreadyExistException;
import com.stackroute.Mongo.MusicApp.exception.TrackNotFoundException;
import com.stackroute.Mongo.MusicApp.model.Track;

import java.util.List;

public interface TrackService {
    public abstract Track addTrack(Track track)throws TrackAlreadyExistException;
    public abstract List<Track> getAllTracks();
    public abstract boolean deleteTrack(String trackId)throws TrackNotFoundException;

    public abstract List<Track> getTrackByArtist(String artist)throws  TrackNotFoundException;

    public abstract List<Track> getAllTrackByRating(String rating)throws TrackNotFoundException;

    public abstract Track updateTrack(Track track)throws TrackNotFoundException;


}
