package com.moviereel.moviereel.models;

/**
 * Project: MovieReel
 * Package: com.moviereel.moviereel.models
 * Created by lusinabrian on 09/09/16 at 20:27
 * Description:JavaBeans Object or a Plain Old Java Object for Series
 */

public class SeriesBeans {
    /*fields*/
    private String seriestitle, seriesposter_url, seriesbackdrop_url, seriesoverview, release_date;
    private int[] seriesgenres;
    private int seriesid, seriesvote_count;
    private double seriespopularity;
    /*constructor*/

    public SeriesBeans(){}

    /*constructor*/
    public SeriesBeans(String seriesposter_url, String seriesoverview, String release_date,int[] seriesgenres, int seriesid, String seriestitle, String seriesbackdrop_url, double seriespopularity, int seriesvote_count) {
        this.seriesgenres = seriesgenres;
        this.seriestitle = seriestitle;
        this.seriesposter_url = seriesposter_url;
        this.seriesoverview = seriesoverview;
        this.release_date = release_date;
        this.seriesid = seriesid;
        this.seriesbackdrop_url = seriesbackdrop_url;
        this.seriespopularity = seriespopularity;
        this.seriesvote_count = seriesvote_count;
    }

    /*ACCESS METHODS*/
    public String getMovie_poster_url() {
        return seriesposter_url;
    }

    public void setMovie_poster_url(String seriesposter_url) {
        this.seriesposter_url = seriesposter_url;
    }

    public String getMovie_backdrop_url() {
        return seriesbackdrop_url;
    }

    public void setMovie_backdrop_url(String seriesbackdrop_url) {
        this.seriesbackdrop_url = seriesbackdrop_url;
    }

    public int getMovie_vote_count() {
        return seriesvote_count;
    }

    public void setMovie_vote_count(int seriesvote_count) {
        this.seriesvote_count = seriesvote_count;
    }

    public double getMovie_popularity() {
        return seriespopularity;
    }

    public void setMovie_popularity(double seriespopularity) {
        this.seriespopularity = seriespopularity;
    }


    public String getMovie_title() {
        return seriestitle;
    }

    public void setMovie_title(String MovieName) {
        this.seriestitle = MovieName;
    }

    public String getMovie_overview() {
        return seriesoverview;
    }

    public void setMovie_overview(String seriesoverview) {
        this.seriesoverview = seriesoverview;
    }

    public int getMovie_id() {
        return seriesid;
    }

    public void setMovie_id(int seriesid) {
        this.seriesid = seriesid;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public int[] getMovie_genres() {
        return seriesgenres;
    }

}
