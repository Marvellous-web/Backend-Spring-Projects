package com.stackroute.MovieCrud.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {
    @Id
    private String movieId;
    private String movieName,genre,rating;

}
