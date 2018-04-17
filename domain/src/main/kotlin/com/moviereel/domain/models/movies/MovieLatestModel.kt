package com.moviereel.domain.models.movies

import com.moviereel.domain.models.GenreModel
import com.moviereel.domain.models.ProductionCompany
import com.moviereel.domain.models.ProductionCountry
import com.moviereel.domain.models.SpokenLanguage
import com.moviereel.domain.models.BaseEntity

/**
 * @author lusinabrian on 15/05/17.
 * *
 * @Notes Data entry for the latest movie
 */
data class MovieLatestModel(
        var belongsToCollection: String? = null,
        var budget: Int = 0,
        var genres: ArrayList<GenreModel>,
        var homepage: String,
        var imdbId: String,
        var productionCompanies: ArrayList<ProductionCompany>,
        var productionCountry: ArrayList<ProductionCountry>,
        var revenue: Int,
        var runtime: Int,
        var spokenLanguage: ArrayList<SpokenLanguage>,
        var status: String,
        var tagline: String
) : BaseEntity()
