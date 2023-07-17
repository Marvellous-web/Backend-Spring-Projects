package org.example.Model;

public class Movie {
    String moviename,genre;
    int movieYear,rating;

    public Movie() {
    }

    public Movie(String moviename, String genre, int movieYear, int rating) {
        this.moviename = moviename;
        this.genre = genre;
        this.movieYear = movieYear;
        this.rating = rating;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(int movieYear) {
        this.movieYear = movieYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "moviename='" + moviename + '\'' +
                ", genre='" + genre + '\'' +
                ", movieYear=" + movieYear +
                ", rating=" + rating +
                '}';
    }
}
