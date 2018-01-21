package com.example.ishanjoshi.movieapp;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;


public class MovieActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    RecyclerView moviesRecyclerView;
    MovieAdapter movieAdapter;
    TmdbMovies tmdbMovies;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getSupportActionBar().setTitle("Edgar Wright's Movies");

        movies = new ArrayList<>();
        populateMovies();

        moviesRecyclerView = findViewById(R.id.RecyclerViewMovies);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, movies);
        moviesRecyclerView.setAdapter(movieAdapter);

        movies.add(new Movie("Baby Driver",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMjM3MjQ1MzkxNl5BMl5BanBnXkFtZTgwODk1ODgyMjI@._V1_QL50_SY1000_CR0,0,674,1000_AL_.jpg",
                "2017"));
        Collections.sort(movies, new MovieSorter());
        Collections.reverse(movies);
        movieAdapter.notifyDataSetChanged();


    }


    private void populateMovies() {

        tmdbMovies = new TmdbApi(getString(R.string.api_key)).getMovies();

        movies.add(new Movie("Hot Fuzz",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMzg4MDJhMDMtYmJiMS00ZDZmLThmZWUtYTMwZDM1YTc5MWE2XkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_QL50_SY999_CR0,0,672,999_AL_.jpg",
                "2007"));
        movies.add(new Movie("Shaun of the Dead",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTg5Mjk2NDMtZTk0Ny00YTQ0LWIzYWEtMWI5MGQ0Mjg1OTNkXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_QL50_SY1000_CR0,0,669,1000_AL_.jpg",
                "2004"));
        movies.add(new Movie("The World's End",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA1MTk1MzY0OV5BMl5BanBnXkFtZTgwNjkzNTUwMDE@._V1_QL50_SY1000_CR0,0,674,1000_AL_.jpg",
                "2013"));
        movies.add(new Movie("The Adventures of Tintin:\n The Secret of the Unicorn",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNDE5MDExNTQ1OF5BMl5BanBnXkFtZTcwMDIxMTM5Ng@@._V1_QL50_SY1000_CR0,0,674,1000_AL_.jpg",
                "2011"));
        movies.add(new Movie("Scott Pilgrim vs. the World",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTkwNTczNTMyOF5BMl5BanBnXkFtZTcwNzUxOTUyMw@@._V1_QL50_SY1000_CR0,0,675,1000_AL_.jpg",
                "2010"));
        movies.add(new Movie("A Fistful of Fingers",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BZDNiYWI0NmYtYzZlMS00YTU1LWI0NGYtYWE3ZDFhYWJmNzYyXkEyXkFqcGdeQXVyMjk4NDkzMTI@._V1_QL50_SY1000_CR0,0,671,1000_AL_.jpg",
                 "1995"));

        Collections.sort(movies, new MovieSorter());
        Collections.reverse(movies);

    }

    class MovieSorter implements Comparator<Movie> {

        @Override
        public int compare(Movie t1, Movie t2) {
            return t1.getMovieReleaseYear().compareTo(t2.getMovieReleaseYear());
        }
    }

}
