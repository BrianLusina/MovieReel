package com.moviereel.domain.interactors

/**
 * @author lusinabrian on 26/04/18.
 * @Notes
 */
class Params() {
    var page = 0
    var language = "eng"

    constructor(page : Int,language: String) : this(){
        this.page = page
        this.language = language
    }

    companion object {
        val EMPTY = Params()
    }
}
