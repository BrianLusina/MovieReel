package com.moviereel.data.api.model.movie.request;

/**
 * @author lusinabrian on 01/04/17
 * top rated request
 */

public class MovieTopRatedRequest extends MovieBaseRequest {

    MovieTopRatedRequest(int page, String language, String region) {
        super(page, language, region);
    }
}
