package com.moviereel.data.api.model.movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseResultsResponse;
import com.moviereel.data.api.model.Genres;
import com.moviereel.data.api.model.ProductionCompany;
import com.moviereel.data.api.model.ProductionCountry;
import com.moviereel.data.api.model.SpokenLanguage;

import java.util.List;

/**
 * @author lusinabrian on 31/03/17
 * Response for getting the latest movie
 */

public class MovieLatestResponse extends BaseResultsResponse {

    @Expose
    @SerializedName("belongs_to_collection")
    private String belongsToCollection;

    @Expose
    @SerializedName("budget")
    private int budget;

    @Expose
    @SerializedName("homepage")
    private String homepage;

    @Expose
    @SerializedName("genres")
    private Genres genres;

    @Expose
    @SerializedName("imdb_id")
    private String imdbId;

    @Expose
    @SerializedName("production_companies")
    private List<ProductionCompany> productionCompanies;

    @Expose
    @SerializedName("production_countries")
    private List<ProductionCountry> productionCountries;

    @Expose
    @SerializedName("revenue")
    private int revenue;

    @Expose
    @SerializedName("runtime")
    private int runtime;

    @Expose
    @SerializedName("spoken_languages")
    private List<SpokenLanguage> spokenLanguages;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("tagline")
    private String tagline;

}
