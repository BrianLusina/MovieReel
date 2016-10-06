package com.moviereel.moviereel.models;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:50
 * Description: Model class that creates an instance of a single movie item. This will contain the properties of a single movie item, such as name, date posted, user who posted it, recipe, ingredients, brief description
 */
public class MovieModel implements Parcelable {
    /*fields*/
    private String movie_title, movie_poster_url, movie_backdrop_url, movie_overview, release_date, movieHomepage, movieImdbId, movieStatus, movieTagline, movieGenres, productionCompanies, productionCountries, spokenLanguages;
    private int[] movie_genres;
    private int movie_id, movie_vote_count, movieRuntime;
    private float movie_popularity, voteAverage;
    private boolean isAdult, hasVideo;
    private long movieRevenue, movieBudget;

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

    /**2nd Constructor that will populate this object from the ID of the Movie*/
    public MovieModel(int movieRuntime, String movieGenres, boolean isAdult, long movieBudget, String movieHomepage, String movieImdbId, long movieRevenue,String movieStatus, String movieTagline,boolean hasVideo, String productionCountries, String productionCompanies, String spokenLanguages){
        this.movieRuntime = movieRuntime;
        this.isAdult = isAdult;
        this.movieBudget = movieBudget;
        this.movieHomepage = movieHomepage;
        this.movieImdbId = movieImdbId;
        this.movieRevenue = movieRevenue;
        this.movieStatus = movieStatus;
        this.hasVideo = hasVideo;
        this.movieTagline = movieTagline;
        this.movieGenres = movieGenres;
        this.productionCompanies =productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
    }

    /**3rd constructor with more details about the movie fetched from the movie id*/
    public MovieModel(String movie_poster_url, String movie_overview, String release_date,int[] movie_genres, int movie_id, String movie_title, String movie_backdrop_url, float movie_popularity, int movie_vote_count, float voteAverage,int movieRuntime, String movieGenres, boolean isAdult, long movieBudget, String movieHomepage, String movieImdbId, long movieRevenue,String movieStatus, String movieTagline,boolean hasVideo, String productionCountries, String productionCompanies, String spokenLanguages) {
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
        this.movieRuntime = movieRuntime;
        this.isAdult = isAdult;
        this.movieBudget = movieBudget;
        this.movieHomepage = movieHomepage;
        this.movieImdbId = movieImdbId;
        this.movieRevenue = movieRevenue;
        this.movieStatus = movieStatus;
        this.hasVideo = hasVideo;
        this.movieTagline = movieTagline;
        this.movieGenres = movieGenres;
        this.productionCompanies =productionCompanies;
        this.productionCountries = productionCountries;
        this.spokenLanguages = spokenLanguages;
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

    public float getVoteAverage() {
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

    public String getMovieHomepage() {
        return movieHomepage;
    }

    public void setMovieHomepage(String movieHomepage) {
        this.movieHomepage = movieHomepage;
    }

    public String getMovieImdbId() {
        return movieImdbId;
    }

    public void setMovieImdbId(String movieImdbId) {
        this.movieImdbId = movieImdbId;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

    public String getMovieTagline() {
        return movieTagline;
    }

    public void setMovieTagline(String movieTagline) {
        this.movieTagline = movieTagline;
    }

    public String getMovieGenres() {
        return movieGenres;
    }

    public void setMovieGenres(String movieGenres) {
        this.movieGenres = movieGenres;
    }

    public long getMovieBudget() {
        return movieBudget;
    }

    public void setMovieBudget(int movieBudget) {
        this.movieBudget = movieBudget;
    }

    public long getMovieRevenue() {
        return movieRevenue;
    }

    public void setMovieRevenue(long movieRevenue) {
        this.movieRevenue = movieRevenue;
    }

    public String getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public String getProductionCountries() {
        return productionCountries;
    }

    public void setProductionCountries(String productionCountries) {
        this.productionCountries = productionCountries;
    }

    public String getSpokenLanguages() {
        return spokenLanguages;
    }

    public void setSpokenLanguages(String spokenLanguages) {
        this.spokenLanguages = spokenLanguages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.movie_title);
        dest.writeString(this.movie_poster_url);
        dest.writeString(this.movie_backdrop_url);
        dest.writeString(this.movie_overview);
        dest.writeString(this.release_date);
        dest.writeString(this.movieHomepage);
        dest.writeString(this.movieImdbId);
        dest.writeString(this.movieStatus);
        dest.writeString(this.movieTagline);
        dest.writeString(this.movieGenres);
        dest.writeString(this.productionCompanies);
        dest.writeString(this.productionCountries);
        dest.writeString(this.spokenLanguages);
        dest.writeIntArray(this.movie_genres);
        dest.writeInt(this.movie_id);
        dest.writeInt(this.movie_vote_count);
        dest.writeInt(this.movieRuntime);
        dest.writeFloat(this.movie_popularity);
        dest.writeFloat(this.voteAverage);
        dest.writeByte(this.isAdult ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hasVideo ? (byte) 1 : (byte) 0);
        dest.writeLong(this.movieRevenue);
        dest.writeLong(this.movieBudget);
    }

    protected MovieModel(Parcel in) {
        this.movie_title = in.readString();
        this.movie_poster_url = in.readString();
        this.movie_backdrop_url = in.readString();
        this.movie_overview = in.readString();
        this.release_date = in.readString();
        this.movieHomepage = in.readString();
        this.movieImdbId = in.readString();
        this.movieStatus = in.readString();
        this.movieTagline = in.readString();
        this.movieGenres = in.readString();
        this.productionCompanies = in.readString();
        this.productionCountries = in.readString();
        this.spokenLanguages = in.readString();
        this.movie_genres = in.createIntArray();
        this.movie_id = in.readInt();
        this.movie_vote_count = in.readInt();
        this.movieRuntime = in.readInt();
        this.movie_popularity = in.readFloat();
        this.voteAverage = in.readFloat();
        this.isAdult = in.readByte() != 0;
        this.hasVideo = in.readByte() != 0;
        this.movieRevenue = in.readLong();
        this.movieBudget = in.readLong();
    }

    public static final Parcelable.Creator<MovieModel> CREATOR = new Parcelable.Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel source) {
            return new MovieModel(source);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public String toString() {
        return "MovieModel{" +
                "movie_title='" + movie_title + '\'' +
                ", movie_poster_url='" + movie_poster_url + '\'' +
                ", movie_backdrop_url='" + movie_backdrop_url + '\'' +
                ", movie_overview='" + movie_overview + '\'' +
                ", release_date='" + release_date + '\'' +
                ", movieHomepage='" + movieHomepage + '\'' +
                ", movieImdbId='" + movieImdbId + '\'' +
                ", movieStatus='" + movieStatus + '\'' +
                ", movieTagline='" + movieTagline + '\'' +
                ", movieGenres='" + movieGenres + '\'' +
                ", productionCompanies='" + productionCompanies + '\'' +
                ", productionCountries='" + productionCountries + '\'' +
                ", spokenLanguages='" + spokenLanguages + '\'' +
                ", movie_genres=" + Arrays.toString(movie_genres) +
                ", movie_id=" + movie_id +
                ", movie_vote_count=" + movie_vote_count +
                ", movieRuntime=" + movieRuntime +
                ", movie_popularity=" + movie_popularity +
                ", voteAverage=" + voteAverage +
                ", isAdult=" + isAdult +
                ", hasVideo=" + hasVideo +
                ", movieRevenue=" + movieRevenue +
                ", movieBudget=" + movieBudget +
                '}';
    }
}
