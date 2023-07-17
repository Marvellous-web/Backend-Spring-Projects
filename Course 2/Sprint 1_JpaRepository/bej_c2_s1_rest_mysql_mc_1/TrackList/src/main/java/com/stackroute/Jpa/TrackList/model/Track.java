package com.stackroute.Jpa.TrackList.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Track {
    @Id
    private String trackId;
    private String trackName,trackComments,tractRating,trackArtist;
}
