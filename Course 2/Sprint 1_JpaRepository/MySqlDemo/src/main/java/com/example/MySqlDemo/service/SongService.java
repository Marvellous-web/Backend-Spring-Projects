package com.example.MySqlDemo.service;

import com.example.MySqlDemo.model.Song;

import java.util.List;

public interface SongService {
    public abstract Song addSong(Song song);
    public abstract List<Song> getSongsByArtist(String artist);
    public abstract List<Song> getSongsByRating(int rating);
    public abstract List<Song> getSongByRatingAndArtist(int rating,String artist);
}
