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

    public Movie(String movieName, String moviePoster, String movieReleaseYear, String movieDescription) {

        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.movieReleaseYear = movieReleaseYear;
        this.movieDescription = movieDescription;

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
