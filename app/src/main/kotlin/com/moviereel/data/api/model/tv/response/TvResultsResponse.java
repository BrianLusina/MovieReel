package com.moviereel.data.api.model.tv.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseResultsResponse;

import org.greenrobot.greendao.annotation.Property;

import java.util.List;

/**
 * @author lusinabrian on 08/04/17
 */

class TvResultsResponse extends BaseResultsResponse {

    @Expose
    @SerializedName("first_air_date")
    @Property(nameInDb = "first_air_date")
    private String firstAirDate;

    @Expose
    @SerializedName("origin_country")
    @Property(nameInDb = "origin_country")
    private List<String> originCountry;

    @Expose
    @SerializedName("name")
    @Property(nameInDb = "name")
    private String name;

    @Expose
    @SerializedName("original_name")
    @Property(nameInDb = "original_name")
    private String originalName;


    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

}
