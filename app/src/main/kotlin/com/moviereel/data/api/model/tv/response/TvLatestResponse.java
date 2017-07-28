package com.moviereel.data.api.model.tv.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.Genres;
import com.moviereel.data.api.model.Networks;
import com.moviereel.data.api.model.ProductionCompany;
import com.moviereel.data.api.model.tv.Seasons;

import java.util.List;

/**
 * @author lusinabrian on 10/04/17
 * This is the response we get back when we do a fetch for the latest tv show
 */

public class TvLatestResponse {

    @Expose
    @SerializedName("backdrop_path")
    private String backdropPath;

//    @Expose
//    @SerializedName("created_by")
//    private List<> createdBy;

    @Expose
    @SerializedName("episode_run_time")
    private List<Integer> episodeRunTime;

    @Expose
    @SerializedName("first_air_date")
    private String firstAirDate;

    @Expose
    @SerializedName("genres")
    private List<Genres> genres;

    @Expose
    @SerializedName("homepage")
    private String homepage;

    @Expose
    @SerializedName("id")
    private int id;

    @Expose
    @SerializedName("in_production")
    private boolean inProduction;

    @Expose
    @SerializedName("languages")
    private List<String> languages;

    @Expose
    @SerializedName("last_air_date")
    private String lastAirDate;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("networks")
    private List<Networks> networks;

    @Expose
    @SerializedName("number_of_episodes")
    private int numberOfEpisodes;

    @Expose
    @SerializedName("number_of_seasons")
    private int numberOfSeasons;

    @Expose
    @SerializedName("origin_country")
    private List<String> originCountry;

    @Expose
    @SerializedName("original_language")
    private String originalLanguage;

    @Expose
    @SerializedName("original_name")
    private String originalName;

    @Expose
    @SerializedName("overview")
    private String overview;

    @Expose
    @SerializedName("popularity")
    private int popularity;

    @Expose
    @SerializedName("poster_path")
    private String posterPath;

    @Expose
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;

    @Expose
    @SerializedName("seasons")
    private List<Seasons> seasons;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("type")
    private String type;

    @Expose
    @SerializedName("vote_average")
    private int voteAverage;

    @Expose
    @SerializedName("vote_count")
    private int voteCount;

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getEpisodeRunTime() {
        return episodeRunTime;
    }

    public void setEpisodeRunTime(List<Integer> episodeRunTime) {
        this.episodeRunTime = episodeRunTime;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInProduction() {
        return inProduction;
    }

    public void setInProduction(boolean inProduction) {
        this.inProduction = inProduction;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getLastAirDate() {
        return lastAirDate;
    }

    public void setLastAirDate(String lastAirDate) {
        this.lastAirDate = lastAirDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Networks> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Networks> networks) {
        this.networks = networks;
    }

    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }

    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }

    public int getNumberOfSeasons() {
        return numberOfSeasons;
    }

    public void setNumberOfSeasons(int numberOfSeasons) {
        this.numberOfSeasons = numberOfSeasons;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<ProductionCompany> getProductionCompanies() {
        return productionCompanies;
    }

    public void setProductionCompanies(List<ProductionCompany> productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public List<Seasons> getSeasons() {
        return seasons;
    }

    public void setSeasons(List<Seasons> seasons) {
        this.seasons = seasons;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(int voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

}
