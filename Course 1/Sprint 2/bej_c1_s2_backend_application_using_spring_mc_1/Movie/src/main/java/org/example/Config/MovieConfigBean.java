package org.example.Config;

import org.example.Model.Movie;
import org.springframework.context.annotation.Bean;

public class MovieConfigBean {
    @Bean("Movie1")
    public Movie getMovie(){
        Movie movie1=new Movie();
        movie1.setMovieYear(2020);
        movie1.setGenre("Comedy");
        movie1.setRating(5);
        movie1.setMoviename("Dhamaal");
        return movie1;
    }
    @Bean("Movie2")
    public Movie getMovie1(){
        Movie movie2=new Movie("Players","Action",2015,4);
        return movie2;
    }
}
