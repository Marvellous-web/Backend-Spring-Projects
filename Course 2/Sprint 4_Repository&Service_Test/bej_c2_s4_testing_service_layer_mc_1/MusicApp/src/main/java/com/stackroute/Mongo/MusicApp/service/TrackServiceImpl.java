package com.stackroute.Mongo.MusicApp.service;

import com.stackroute.Mongo.MusicApp.exception.TrackAlreadyExistException;
import com.stackroute.Mongo.MusicApp.exception.TrackNotFoundException;
import com.stackroute.Mongo.MusicApp.model.Track;
import com.stackroute.Mongo.MusicApp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    private TrackRepository trackRepository;
    @Override
    public Track addTrack(Track track)throws TrackAlreadyExistException {
        if (trackRepository.findById(track.getTrackId()).isEmpty()){
            return trackRepository.save(track);
        }
        throw new TrackAlreadyExistException();
    }

    @Override
    public List<Track> getAllTracks() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public boolean deleteTrack(String trackId) throws TrackNotFoundException {
        if (trackRepository.findById(trackId).isPresent()){
            trackRepository.deleteById(trackId);
            return true;
        }
        throw new TrackNotFoundException();
    }

    @Override
    public List<Track> getTrackByArtist(String artist) throws TrackNotFoundException {
        return trackRepository.getAllTrackByArtist(artist);
    }

    @Override
    public List<Track> getAllTrackByRating(String rating) throws TrackNotFoundException {
        return trackRepository.getAllTrackByRating(rating);
    }

    @Override
    public Track updateTrack(Track track) throws TrackNotFoundException {
        if (trackRepository.findById(track.getTrackId()).isPresent()){
            return trackRepository.save(track);
        }
        throw new TrackNotFoundException();
    }
}
