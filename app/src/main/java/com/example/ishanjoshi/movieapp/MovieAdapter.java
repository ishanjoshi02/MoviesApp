package com.example.ishanjoshi.movieapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

import jp.wasabeef.picasso.transformations.BlurTransformation;

/**
 * Created by Ishan Joshi on 14-Jan-18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    ArrayList<Movie> movies;
    public Context mContext;

    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        this.mContext = context;
        this.movies = movies;
    }

    @Override
    public MovieAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        return new MovieViewHolder(LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_view_movie_info, parent, false
        ));
    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MovieViewHolder movieViewHolder, int position) {

        final Movie currentMovie = movies.get(position);
        if (currentMovie.getMoviePoster() != null) {

            Picasso.with(mContext)
                    .load(currentMovie.getMoviePoster())
                    .into(movieViewHolder.moviePosterImageView);


        }
        movieViewHolder.movieRatingTextView.setText(currentMovie.getMovieRating());
        movieViewHolder.movieNameTextView.setText(currentMovie.getMovieName());
        movieViewHolder.movieReleaseYearTextView.setText(currentMovie.getMovieReleaseYear());
        movieViewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(mContext, MovieInfo.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(
                                "Movie",
                                currentMovie
                        );
                        intent.putExtras(bundle);
                        mContext.startActivity(intent);

                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView moviePosterImageView;
        TextView movieNameTextView;
        TextView movieReleaseYearTextView;
        TextView movieDescriptionTextView;
        TextView movieRatingTextView;

        public MovieViewHolder(View itemView) {

            super(itemView);
            this.moviePosterImageView = itemView.findViewById(R.id.ImageViewMoviePoster);
            this.movieNameTextView = itemView.findViewById(R.id.TextViewMovieName);
            this.movieReleaseYearTextView = itemView.findViewById(R.id.TextViewMovieReleaseYear);
            this.movieDescriptionTextView = itemView.findViewById(R.id.TextViewMovieDescription);
            this.movieRatingTextView = itemView.findViewById(R.id.TextViewMovieRating);

        }
    }


}
