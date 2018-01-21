package com.example.ishanjoshi.movieapp;

import java.io.Serializable;

/**
 * Created by Ishan Joshi on 14-Jan-18.
 */

public class Movie implements Serializable {

    String movieName;
    String moviePoster;
    String movieReleaseYear;
    String movieDescription;
    String movieRating;

    public Movie(String movieName, String moviePoster, String movieReleaseYear, String movieDescription, String movieRating) {

        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.movieReleaseYear = movieReleaseYear;
        this.movieDescription = movieDescription;
        this.movieRating = movieRating;

    }

    public String getMovieRating() {
        return movieRating;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMoviePoster() {
        return moviePoster;
    }

    public String getMovieReleaseYear() {
        return movieReleaseYear;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
}
