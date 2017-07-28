package com.moviereel.data.api.model.movie.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseRequest;

import io.reactivex.annotations.Nullable;

/**
 * @author lusinabrian on 08/04/17
 * every api endpoint call made to the movie endpoint will extend this class
 */

abstract class MovieBaseRequest extends BaseRequest {

    @Expose
    @SerializedName("region")
    private String region;

    MovieBaseRequest(int page, String language, @Nullable String region) {
        super(page, language);
        this.region = region;
    }

    MovieBaseRequest(String language){
        super(language);
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
