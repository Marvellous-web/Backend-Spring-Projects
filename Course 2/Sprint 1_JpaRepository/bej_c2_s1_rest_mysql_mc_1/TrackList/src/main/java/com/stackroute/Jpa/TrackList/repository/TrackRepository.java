package com.stackroute.Jpa.TrackList.repository;

import com.stackroute.Jpa.TrackList.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track,String> {
    public abstract List<Track> findAllByTrackArtist(String artist);
}
