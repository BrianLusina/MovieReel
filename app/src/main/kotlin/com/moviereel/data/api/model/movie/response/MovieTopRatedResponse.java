package com.moviereel.data.api.model.movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseResponse;

import java.util.List;

/**
 * @author lusinabrian on 01/04/17
 */

public class MovieTopRatedResponse extends BaseResponse {

    @Expose
    @SerializedName("results")
    private List<MovieResultsResponse> results;

    public List<MovieResultsResponse> getResults() {
        return results;
    }

    public void setResults(List<MovieResultsResponse> results) {
        this.results = results;
    }
}
