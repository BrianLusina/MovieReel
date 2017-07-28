package com.moviereel.data.api.model.movie.request;

/**
 * @author lusinabrian on 01/04/17
 * Request for getting a list of popular movies, list is updated daily
 */

public class MoviePopularRequest extends MovieBaseRequest {

    MoviePopularRequest(int page, String language, String region) {
        super(page, language, region);
    }
}
