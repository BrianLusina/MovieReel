package com.moviereel.moviereel.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:50
 * Description: Model class that creates an instance of a single movie item. This will contain the properties of a single movie item, such as name, date posted, user who posted it, recipe, ingredients, brief description
 */
public class MovieModel implements Parcelable{
    /*fields*/
    private String movie_title, movie_poster_url, movie_backdrop_url, movie_overview, release_date, movieHomepage, movieImdbId, movieStatus, movieTagline;
    private int[] movie_genres;
    private int movie_id, movie_vote_count, movieRuntime, movieBudget, movieRevenue;
    private float movie_popularity, voteAverage;
    private boolean isAdult, hasVideo;

    /** Empty constructor for non-parcel objects*/
    public MovieModel(){}

    /**constructor used to get now playing data for movies
     **/
    public MovieModel(String movie_poster_url, String movie_overview, String release_date,int[] movie_genres, int movie_id, String movie_title, String movie_backdrop_url, float movie_popularity, int movie_vote_count, float voteAverage) {
        this.movie_genres = movie_genres;
        this.movie_title = movie_title;
        this.movie_poster_url = movie_poster_url;
        this.movie_overview = movie_overview;
        this.release_date = release_date;
        this.movie_id = movie_id;
        this.movie_backdrop_url = movie_backdrop_url;
        this.movie_popularity = movie_popularity;
        this.movie_vote_count = movie_vote_count;
        this.voteAverage = voteAverage;
    }

    // TODO: 02/10/16 Add genres, production companies, production countries, spoken languages
    /**2nd Constructor that will populate this object from the ID of the Movie*/
    public MovieModel(int movieRuntime, boolean isAdult, String movie_backdrop_url, int movieBudget, String movieHomepage, String movieImdbId, int movieRevenue,String movieStatus, String movieTagline,boolean hasVideo){
        this.movieRuntime = movieRuntime;
        this.isAdult = isAdult;
        this.movie_backdrop_url = movie_backdrop_url;
        this.movieBudget = movieBudget;
        this.movieHomepage = movieHomepage;
        this.movieImdbId = movieImdbId;
        this.movieRevenue = movieRevenue;
        this.movieStatus = movieStatus;
        this.hasVideo = hasVideo;
        this.movieTagline = movieTagline;
    }


    protected MovieModel(Parcel in) {
        movie_title = in.readString();
        movie_poster_url = in.readString();
        movie_backdrop_url = in.readString();
        movie_overview = in.readString();
        release_date = in.readString();
        movie_genres = in.createIntArray();
        movie_id = in.readInt();
        movie_vote_count = in.readInt();
        movie_popularity = in.readFloat();
        voteAverage = in.readFloat();
        isAdult = in.readByte() != 0;
        hasVideo = in.readByte() != 0;
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movie_title);
        dest.writeString(movie_poster_url);
        dest.writeString(movie_backdrop_url);
        dest.writeString(movie_overview);
        dest.writeString(release_date);
        dest.writeIntArray(movie_genres);
        dest.writeInt(movie_id);
        dest.writeInt(movie_vote_count);
        dest.writeDouble(movie_popularity);
        dest.writeDouble(voteAverage);
        dest.writeByte((byte) (isAdult ? 1 : 0));
        dest.writeByte((byte) (hasVideo ? 1 : 0));
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

    public void setMovie_popularity(float movie_popularity) {
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

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public int getMovieRuntime() {
        return movieRuntime;
    }

    public void setMovieRuntime(int movieRuntime) {
        this.movieRuntime = movieRuntime;
    }
}
