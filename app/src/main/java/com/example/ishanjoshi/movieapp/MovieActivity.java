package com.example.ishanjoshi.movieapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ExecutionException;


public class MovieActivity extends AppCompatActivity {

    ArrayList<Movie> movies;
    RecyclerView moviesRecyclerView;
    MovieAdapter movieAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        getSupportActionBar().setTitle("Popular Movies");

        movies = new ArrayList<>();
        getMovieList();
        Collections.sort(movies, new MovieSorter());
        Collections.reverse(movies);
        moviesRecyclerView = findViewById(R.id.RecyclerViewMovies);
        moviesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        movieAdapter = new MovieAdapter(this, movies);
        moviesRecyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();


    }

    private void getMovieList() {
        try {
            movies = (ArrayList<Movie>) new MovieAsyncTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    class MovieSorter implements Comparator<Movie> {

        @Override
        public int compare(Movie t1, Movie t2) {
            return t1.getMovieReleaseYear().compareTo(t2.getMovieReleaseYear());
        }
    }

}
