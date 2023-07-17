package com.stackroute.Jpa.TrackList.service;

import com.stackroute.Jpa.TrackList.model.Track;
import com.stackroute.Jpa.TrackList.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService{
    @Autowired
    private TrackRepository  trackRepository;
    @Override
    public List<Track> getAllTrack() {
        return (List<Track>) trackRepository.findAll();
    }

    @Override
    public Track addTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public boolean deleteTrack(String trackId) {
        trackRepository.deleteById(trackId);
        return true;
    }

    @Override
    public Track updateTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public Track getTrackById(String trackId) {
        if(trackRepository.findById(trackId).isPresent()){
            return trackRepository.findById(trackId).get();
        }
        return null;
    }

    @Override
    public List<Track> getTrackByArtist(String artist) {
        return trackRepository.findAllByTrackArtist(artist);
    }
}
