package com.moviereel.moviereel;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import okhttp3.OkHttpClient;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 10:41
 * Description: Responsible for making HTTP call and getting the response
 * url – The url to make a http call
 * method – The http method either GET or POST. We should pass ServiceHandler.GET or ServiceHandler.POST as value
 * params – Any parameters you want to submit to that url. This is optional.
 */
public class MovieFetch{
    protected final static String KEY = "?api_key=2f30bdb7e9742c26d4ea364f62f38163";
    protected final static String BASEURL="https://api.themoviedb.org/3/";

    /*url to fetch GENRES*/
    protected final static String GENRES = BASEURL + "genre/movie/list" + KEY;

    /*get movies per genre add id to this link to get movies per genre*/
    protected final static String MOVIES_PER_GENRE = BASEURL + "genre/";
    /*append this to above string to get list of movies*/
    protected final static String MOVIES_PER_GENRE_endpt = "movies"+KEY;
    OkHttpClient client = new OkHttpClient();

    /*constructor*/
    public MovieFetch() {}

    public String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /*fetches all the genres*/
    public String fetchAllGenres() throws IOException {
       return run(GENRES);
    }


/*END*/
}
