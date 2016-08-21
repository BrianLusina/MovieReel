package com.moviereel.moviereel.movies;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 20/08/16 at 09:50
 * <p/>
 * Description: Model class that creates an instance of a single movie item. This will contain the properties of a single movie item, such as name, date posted, user who posted it, recipe, ingredients, brief description
 */
public class MovieModel {
    /*fields*/
    private String MovieName, moviePosterName, briefDesc, datePosted;
    private int thumbnail, moviePosterImage;

    /*constructor*/
    public MovieModel(){}

    /*constructor*/
    public MovieModel(String MovieName, String moviePosterName, String briefDesc, String datePosted, int thumbnail, int moviePosterImage) {
        this.MovieName = MovieName;
        this.moviePosterName = moviePosterName;
        this.briefDesc = briefDesc;
        this.datePosted = datePosted;
        this.thumbnail = thumbnail;
        this.moviePosterImage = moviePosterImage;
    }

/*ACCESS METHODS*/

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public String getmoviePosterName() {
        return moviePosterName;
    }

    public void setmoviePosterName(String moviePosterName) {
        this.moviePosterName = moviePosterName;
    }

    public String getBriefDesc() {
        return briefDesc;
    }

    public void setBriefDesc(String briefDesc) {
        this.briefDesc = briefDesc;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public int getmoviePosterImage() {
        return moviePosterImage;
    }

    public void setmoviePosterImage(int moviePosterImage) {
        this.moviePosterImage = moviePosterImage;
    }

}
