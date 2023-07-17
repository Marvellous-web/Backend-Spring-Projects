package com.stackroute.Jpa.TrackList.service;

import com.stackroute.Jpa.TrackList.model.Track;

import java.util.List;

public interface TrackService {
    public abstract List<Track> getAllTrack();
    public abstract Track addTrack(Track track);
    public abstract boolean deleteTrack(String trackId);
    public abstract Track updateTrack(Track track);
    public abstract Track getTrackById(String trackId);

    public abstract List<Track> getTrackByArtist(String artist);
}
