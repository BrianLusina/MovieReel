package com.moviereel.data.api.model.movie.request;

/**
 * @author lusinabrian on 01/04/17
 */

public class MovieUpcomingRequest extends MovieBaseRequest {

    MovieUpcomingRequest(int page, String language, String region) {
        super(page, language, region);
    }
}
