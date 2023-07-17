package com.example.MySqlDemo.service;

import com.example.MySqlDemo.model.Song;
import com.example.MySqlDemo.repository.SongRepos;
import com.example.MySqlDemo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepos songRepos;
    @Override
    public Song addSong(Song song) {
        return songRepos.save(song);
    }

    @Override
    public List<Song> getSongsByArtist(String artist) {
        return songRepos.findAllByArtist(artist);
    }

    @Override
    public List<Song> getSongsByRating(int rating) {
        return songRepos.getSongByRating(rating);
    }

    @Override
    public List<Song> getSongByRatingAndArtist(int rating, String artist) {
        return songRepos.getSongByRatingAndArtist(rating,artist);
    }
}
