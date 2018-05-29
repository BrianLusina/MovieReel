package com.moviereel.remote.factory

import com.moviereel.remote.models.movie.MovieNowPlayingApiResponse

class MovieFactory {
    companion object MovieNowPlayingFactory {
        fun makeMovieNowPlayingResponse() : MovieNowPlayingApiResponse{
            return MovieNowPlayingApiResponse(
                    randomId(), randomVoteCount(), randomBoolean(),
                    randomVoteAverage(), randomTitle(), randomPopularity(),
                    randomPosterPath(), randomOriginalLang(), randomTitle(),
                    randomGenreIds(), randomBackdropPath(), randomBoolean(),
                    randomOverview(1000), randomReleaseDate()
            )
        }

        fun makeMovieNowPlayingResponseCollection(count: Int = 5) : Collection<MovieNowPlayingApiResponse> {
            val movieApiResponses = arrayListOf<MovieNowPlayingApiResponse>()
            repeat(count){
                movieApiResponses.add(makeMovieNowPlayingResponse())
            }

            return movieApiResponses
        }
    }
}
