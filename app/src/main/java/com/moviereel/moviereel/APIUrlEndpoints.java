package com.moviereel.moviereel;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 10:41
 * Description: Responsible for making HTTP call and getting the response
 * url – The url to make a http call
 * method – The http method either GET or POST. We should pass ServiceHandler.GET or ServiceHandler.POST as value
 * params – Any parameters you want to submit to that url. This is optional.
 */
public class APIUrlEndpoints {
    private String KEY = "?api_key=2f30bdb7e9742c26d4ea364f62f38163";
    private String BASEURL="https://api.themoviedb.org/3/";
    private String IMAGE_BASE = "http://image.tmdb.org/t/p/w500";

    /*url to fetch GENRES*/
    private String GENRES = BASEURL + "genre/movie/list" + KEY;

    /*Now playing url for all movies*/
    private String NOW_PLAYING = BASEURL + "movie/now_playing" + KEY;

    /*get movies per genre add id to this link to get movies per genre*/
    private String MOVIES_PER_GENRE = BASEURL + "genre/";

    /*append this to above string to get list of movies*/
    private String MOVIES_PER_GENRE_endpt = "movies"+KEY;

    public APIUrlEndpoints() {}

    public String getKEY() {
        return KEY;
    }

    public String getBASEURL() {
        return BASEURL;
    }

    public String getGENRES() {
        return GENRES;
    }

    public String getNowPlaying() {
        return NOW_PLAYING;
    }

    public String getMoviesPerGenre() {
        return MOVIES_PER_GENRE;
    }

    public String getMOVIES_PER_GENRE_endpt() {
        return MOVIES_PER_GENRE_endpt;
    }

    public String getIMAGE_BASE() {return IMAGE_BASE;}

    public void setIMAGE_BASE(String IMAGE_BASE) {this.IMAGE_BASE = IMAGE_BASE;}

/*END*/
}