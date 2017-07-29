package com.moviereel.data.api.model.movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.moviereel.data.api.model.BaseResponse;
import com.moviereel.data.api.model.BaseResultsResponse.MovieResultsResponse;

import java.util.List;

/**
 * @author lusinabrian on 01/04/17
 * Response we get when we request for a list of popular movies
 */

public class MoviePopularResponse extends BaseResponse {

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
