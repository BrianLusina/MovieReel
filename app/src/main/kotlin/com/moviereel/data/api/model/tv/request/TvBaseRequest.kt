package com.moviereel.data.api.model.tv.request

import com.moviereel.data.api.model.BaseRequest

/**
 * @author lusinabrian on 08/04/17
 * * Every request made to the tv api endpoint will have to extend this class
 */

abstract class TvBaseRequest : BaseRequest {

    constructor(page: Int, language: String) : super(page, language) {}

    constructor(language: String) : super(language) {}
}
