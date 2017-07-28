package com.moviereel.data.api.model.movie.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author lusinabrian on 29/03/17
 * response we get when interacting with the now playing response
 * */

public class MovieNowPlayingResponse extends MovieBaseResponse {

    @Expose
    @SerializedName("dates")
    private DatesResponse datesResponse;

    @Expose
    @SerializedName("results")
    private List<MovieResultsResponse> results;

    public DatesResponse getDatesResponse() {
        return datesResponse;
    }

    public void setDatesResponse(DatesResponse datesResponse) {
        this.datesResponse = datesResponse;
    }

    public List<MovieResultsResponse> getResults() {
        return results;
    }

    public void setResults(List<MovieResultsResponse> results) {
        this.results = results;
    }

}
