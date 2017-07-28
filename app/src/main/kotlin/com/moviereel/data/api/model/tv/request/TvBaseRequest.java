package com.moviereel.data.api.model.tv.request;

import com.moviereel.data.api.model.BaseRequest;

/**
 * @author lusinabrian on 08/04/17
 * Every request made to the tv api endpoint will have to extend this class
 */

abstract class TvBaseRequest extends BaseRequest {

    TvBaseRequest(int page, String language) {
        super(page, language);
    }

    TvBaseRequest(String language) {
        super(language);
    }
}
