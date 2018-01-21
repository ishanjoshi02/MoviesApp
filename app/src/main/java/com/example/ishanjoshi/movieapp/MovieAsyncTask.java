package com.example.ishanjoshi.movieapp;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ishan Joshi on 21-Jan-18.
 */

public class MovieAsyncTask extends AsyncTask<Void, Void, List<Movie>> {

    private static final String TAG = "MovieAsyncTask";
    URL tmdbURL;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Movie> doInBackground(Void... voids) {

        ArrayList<Movie> myMovies = new ArrayList<>();

        try {

            HttpURLConnection connection = getConnection();

            // Check repsonse code and convert raw bytes to string
            int responseCode = connection.getResponseCode();
            Log.d(TAG, "doInBackground: \nResponse Code" + responseCode);

            switch (responseCode) {

                case HttpURLConnection.HTTP_OK: {

                    InputStream mInputStream = connection.getInputStream();
                    String response = getStringFromStream(mInputStream);

                    JSONArray mJsonArray = new JSONObject(response)
                            .getJSONArray("results");

                    for (int i = 0; i < mJsonArray.length(); i++) {

                        JSONObject temp = mJsonArray.getJSONObject(i);
                        myMovies.add(
                                new Movie(
                                        temp.getString("title"),
                                        "http://image.tmdb.org/t/p/w500/" + temp.getString( "poster_path"),
                                        temp.getString("release_date"),
                                        temp.getString("overview")
                                )
                        );

                    }

                }

                case HttpURLConnection.HTTP_NOT_FOUND: {
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "doInBackground: ", e);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return myMovies;
    }

    private String getStringFromStream(InputStream mInputStream) throws IOException {

        BufferedReader mBufferedReader = new BufferedReader(
                new InputStreamReader(mInputStream)
        );

        StringBuilder builder = new StringBuilder();
        String line;

        while ((line = mBufferedReader.readLine()) != null) {
            builder.append(line);
        }

        return builder.toString();

    }

    public String reverse(String s) {

        String reversedString = "";
        for(int i=s.length(); i>0; i--) {
            reversedString += s.charAt(i-1);
        }

        return reversedString;
    }


    @Override
    protected void onPostExecute(List<Movie> movies) {
        super.onPostExecute(movies);
    }

    HttpURLConnection getConnection() throws IOException {

        // Sets up HttpUrlConnection
        int connectionTimeOut = 1000 * 60 * 60;
        int readConnectionTimeOut = 1000 * 60 * 60;
        tmdbURL = new URL("http://api.themoviedb.org/3/discover/movie?api_key=e4df8ab85309b45e5a089cfb7345b47e");
        HttpURLConnection connection = (HttpURLConnection) tmdbURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(connectionTimeOut);
        connection.setReadTimeout(readConnectionTimeOut);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.connect();

        return connection;
    }

}
