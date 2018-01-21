package com.example.ishanjoshi.movieapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.BlurTransformation;

public class MovieInfo extends AppCompatActivity {

    ImageView blurredPoster;
    TextView movieNameTextView;
    TextView movieDescriptionTextView;
    TextView movieReleaseYearTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Movie currentMovie = (Movie) bundle.getSerializable("Movie");


        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(true);
        mActionBar.setHomeButtonEnabled(true);
        mActionBar.setTitle(currentMovie.getMovieName());
        mActionBar.setDisplayHomeAsUpEnabled(true);

        blurredPoster = findViewById(R.id.blurredImageView);

        Picasso.with(this)
                .load(currentMovie.getMoviePoster())
                .transform(new BlurTransformation(this))
                .into(blurredPoster);

        Picasso.with(this)
                .load(currentMovie.getMoviePoster())
                .into((ImageView) findViewById(R.id.ImageViewMoviePoster1));


        movieNameTextView = findViewById(R.id.TextViewMovieName1);
        movieReleaseYearTextView = findViewById(R.id.TextViewMovieReleaseYear1);
        movieDescriptionTextView = findViewById(R.id.TextViewMovieDescription);

        movieNameTextView.setText(currentMovie.getMovieName());
        movieReleaseYearTextView.setText(currentMovie.getMovieReleaseYear());
        movieDescriptionTextView.setText(currentMovie.getMovieDescription());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {

            case android.R.id.home:
                startActivity(
                        new Intent(
                                MovieInfo.this, MovieActivity.class
                        )
                );
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}
