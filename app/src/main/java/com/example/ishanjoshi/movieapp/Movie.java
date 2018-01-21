package com.example.ishanjoshi.movieapp;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by Ishan Joshi on 14-Jan-18.
 */

public class Movie implements Serializable {

    String movieName;
    String moviePoster;
    String movieReleaseYear;

    public Movie(String movieName, String moviePoster, String movieReleaseYear) {
        this.movieName = movieName;
        this.moviePoster = moviePoster;
        this.movieReleaseYear = movieReleaseYear;
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
}
