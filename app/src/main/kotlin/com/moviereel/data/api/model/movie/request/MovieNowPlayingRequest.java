package com.moviereel.data.api.model.movie.request;

import io.reactivex.annotations.Nullable;

/**
 * @author lusinabrian on 31/03/17
 */

public class MovieNowPlayingRequest extends MovieBaseRequest{

    public MovieNowPlayingRequest(String language) {
        super(language);
    }

    public MovieNowPlayingRequest(int page, String language, @Nullable String region) {
        super(page, language, region);
    }
}
