package com.stackroute.Mongo.MusicApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Track {
    @Id
    private String trackId;
    private String trackName,trackRating;
    private Artist trackArtist;
}
