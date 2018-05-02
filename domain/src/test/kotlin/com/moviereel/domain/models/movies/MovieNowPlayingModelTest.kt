package com.moviereel.domain.models.movies

import com.moviereel.domain.factory.DataFactory
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class MovieNowPlayingModelTest : Spek({

  describe("MovieNowPlayingModel") {
      val id = DataFactory.randomId()
      val voteCount = DataFactory.randomVoteCount()
      val video = DataFactory.randomBoolean()
      val voteAverage = DataFactory.randomVoteAverage()
      val title = DataFactory.randomTitle()
      val popularity = DataFactory.randomPopularity()
      val posterPath = DataFactory.randomPosterPath()
      val originalLang = DataFactory.randomOriginalLang()
      val originalTitle = DataFactory.randomOriginalLang()
      val genreIds = DataFactory.randomGenreIds()
      val backdropPath = DataFactory.randomBackdropPath()
      val adult = DataFactory.randomBoolean()
      val overview = DataFactory.randomOverview(10)
      val releaseDate = DataFactory.randomReleaseDate()

      val movieNowPlayingModel = MovieNowPlayingModel(
              id, voteCount, video, voteAverage, title, popularity, posterPath, originalLang,
              originalTitle, genreIds, backdropPath, adult, overview, releaseDate
      )

      it("should be able to return id"){
          val movieId = movieNowPlayingModel.id
          assertThat(movieId).isEqualTo(id)
      }

      it("should be able to set an id"){
          val newId = DataFactory.randomId()
          movieNowPlayingModel.id = newId
          assertThat(movieNowPlayingModel.id).isEqualTo(newId)
      }
  }
})

