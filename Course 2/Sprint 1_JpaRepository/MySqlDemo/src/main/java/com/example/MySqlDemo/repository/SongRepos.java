package com.example.MySqlDemo.repository;

import com.example.MySqlDemo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepos extends JpaRepository<Song,String> {

    public abstract List<Song> findAllByArtist(String artist);
//    @Query("select s from Song s where s.rating>=?1")
//    public abstract List<Song> getSongByRating(int r);
    //or
    public abstract List<Song> getSongByRating(int r);

    //public abstract List<Song> getSongByRatingAndArtist(int rating,String artist);
    //or
    @Query("select s from Song s where s.rating=?1 and s.artist=?2")
    public abstract List<Song> getSongByRatingAndArtist(int rating,String artist);

}
