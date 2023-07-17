package com.example.MySqlDemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Song {
    @Id
    private String song_id;
    private String name,artist,duration;
    private int rating;
}
