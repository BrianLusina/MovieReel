package com.moviereel.moviereel.models;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:50
 * <p/>
 * Description: Model class that creates an instance of a single movie item. This will contain the properties of a single movie item, such as name, date posted, user who posted it, recipe, ingredients, brief description
 */
public class MovieModel {
    /*fields*/
    private String movie_title, movie_poster_url, movie_backdrop_url, movie_overview, release_date;
    private int[] movie_genres;
    private int movie_id, movie_vote_count;
    private double movie_popularity;
    /*constructor*/
    public MovieModel(){}

    /*constructor*/
    public MovieModel(String movie_poster_url, String movie_overview, String release_date,int[] movie_genres, int movie_id, String movie_title, String movie_backdrop_url, double movie_popularity, int movie_vote_count) {
        this.movie_genres = movie_genres;
        this.movie_title = movie_title;
        this.movie_poster_url = movie_poster_url;
        this.movie_overview = movie_overview;
        this.release_date = release_date;
        this.movie_id = movie_id;
        this.movie_backdrop_url = movie_backdrop_url;
        this.movie_popularity = movie_popularity;
        this.movie_vote_count = movie_vote_count;
    }

/*ACCESS METHODS*/
public String getMovie_poster_url() {
    return movie_poster_url;
}

    public void setMovie_poster_url(String movie_poster_url) {
        this.movie_poster_url = movie_poster_url;
    }

    public String getMovie_backdrop_url() {
        return movie_backdrop_url;
    }

    public void setMovie_backdrop_url(String movie_backdrop_url) {
        this.movie_backdrop_url = movie_backdrop_url;
    }

    public int getMovie_vote_count() {
        return movie_vote_count;
    }

    public void setMovie_vote_count(int movie_vote_count) {
        this.movie_vote_count = movie_vote_count;
    }

    public double getMovie_popularity() {
        return movie_popularity;
    }

    public void setMovie_popularity(double movie_popularity) {
        this.movie_popularity = movie_popularity;
    }


    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String MovieName) {
        this.movie_title = MovieName;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public void setMovie_overview(String movie_overview) {
        this.movie_overview = movie_overview;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int[] getMovie_genres() {
        return movie_genres;
    }
    public void setMovie_genres(int[] genres){
        this.movie_genres = genres;
    }
}
