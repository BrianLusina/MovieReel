package com.moviereel.data

import android.content.Context

import com.moviereel.data.api.ApiHeader
import com.moviereel.data.api.ApiHelper
import com.moviereel.data.api.model.movie.request.MovieLatestRequest
import com.moviereel.data.api.model.movie.request.MovieNowPlayingRequest
import com.moviereel.data.api.model.movie.request.MoviePopularRequest
import com.moviereel.data.api.model.movie.request.MovieTopRatedRequest
import com.moviereel.data.api.model.movie.request.MovieUpcomingRequest
import com.moviereel.data.api.model.movie.response.MovieLatestResponse
import com.moviereel.data.api.model.movie.response.MovieNowPlayingResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.api.model.movie.response.MovieTopRatedResponse
import com.moviereel.data.api.model.movie.response.MovieUpcomingResponse
import com.moviereel.data.api.model.tv.request.TvAiringTodayRequest
import com.moviereel.data.api.model.tv.request.TvLatestRequest
import com.moviereel.data.api.model.tv.request.TvOnTheAirRequest
import com.moviereel.data.api.model.tv.request.TvPopularRequest
import com.moviereel.data.api.model.tv.request.TvTopRatedRequest
import com.moviereel.data.api.model.tv.response.TvAiringTodayResponse
import com.moviereel.data.api.model.tv.response.TvLatestResponse
import com.moviereel.data.api.model.tv.response.TvOnTheAirResponse
import com.moviereel.data.api.model.tv.response.TvPopularResponse
import com.moviereel.data.api.model.tv.response.TvTopRatedResponse
import com.moviereel.data.db.DbHelper
import com.moviereel.data.db.models.movie.MovieLatestModel
import com.moviereel.data.db.models.movie.MovieNowPlayingModel
import com.moviereel.data.db.models.movie.MoviePopularModel
import com.moviereel.data.db.models.movie.MovieTopRatedModel
import com.moviereel.data.files.FileHelper
import com.moviereel.data.prefs.PreferencesHelper
import com.moviereel.di.ApplicationContext

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Observable

/**
 * @author lusinabrian on 28/03/17
 * * [Singleton] indicates that there will only be one object of this in the entire application
 * * thus ensuring that the app does not have several objects that will interact with the Model layer
 * * of the application
 * * The constructor is annoted with [Inject] to instruct dagger to accumulate all the param
 * * dependencies when class is being constructed
 */

@Singleton
class DataManagerImpl
/**
 * Constructor for the DataMangerImpl. This will create a new object of this class with the
 * following params
 * @param mContext the application context to use when invoking this object
 * *
 * @param mDbHelper Interface to interact with the database layer of the application
 * *
 * @param mApiHelper Interface when interacting with the API for data fetching
 * *
 * @param mFileHelper interface when interacting with the File helper class for interacting with
 * *                    files
 * *
 * @param mPreferenceHelper preference interface when interacting with the preference layer of the a
 * * application when storing data persistently in [android.content.SharedPreferences]
 * *
 */
@Inject
constructor(@param:ApplicationContext private val mContext: Context, private val mDbHelper: DbHelper, private val mPreferenceHelper: PreferencesHelper, private val mApiHelper: ApiHelper, private val mFileHelper: FileHelper) : DataManager {

    /**
     * gets the [ApiHeader] which will be used when making requests

     * @return [ApiHeader]
     */
    override fun getApiHeader(): ApiHeader {
        return mApiHelper.getApiHeader()
    }

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing

     * @param request the request to pass to the api
     * *
     * @return [MovieNowPlayingResponse] response to return from the api call
     */
    override fun doGetMoviesNowPlayingApiCall(request: MovieNowPlayingRequest): Observable<MovieNowPlayingResponse> {
        return mApiHelper.doGetMoviesNowPlayingApiCall(request)
    }

    /**
     * API call to get the latest movies being shown

     * @param request the request of the latest movies to fetch
     * *
     * @return [MovieLatestResponse] response object to return from the api call
     */
    override fun doGetMoviesLatestApiCall(request: MovieLatestRequest): Observable<MovieLatestResponse> {
        return mApiHelper.doGetMoviesLatestApiCall(request)
    }

    /**
     * Does an api call to get a list of popular movies

     * @param request Request to make to fetch popular movies
     * *
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopularApiCall(request: MoviePopularRequest): Observable<MoviePopularResponse> {
        return mApiHelper.doGetMoviesPopularApiCall(request)
    }

    /**
     * Makes an api call to fetch the top rated movies

     * @param request request that is made to the api
     * *
     * @return [MovieTopRatedResponse] what we get back from the api as an object
     */
    override fun doGetMoviesTopRatedApiCall(request: MovieTopRatedRequest): Observable<MovieTopRatedResponse> {
        return mApiHelper.doGetMoviesTopRatedApiCall(request)
    }

    /**
     * Makes an API call to get upcoming movies

     * @param request Request to make to fetch upcoming movies
     * *
     * @return [MovieUpcomingResponse] what we get back when we request for upcoming movies
     */
    override fun doGetMoviesUpcomingApiCall(request: MovieUpcomingRequest): Observable<MovieUpcomingResponse> {
        return mApiHelper.doGetMoviesUpcomingApiCall(request)
    }

    /**
     * Get a list of all the top rated tv shows on TMDB

     * @param ratedRequest the request to send out to get the top rated tv shows
     */
    override fun doGetTvTopRatedApiCall(ratedRequest: TvTopRatedRequest): Observable<TvTopRatedResponse> {
        return mApiHelper.doGetTvTopRatedApiCall(ratedRequest)
    }

    /**
     * get popular tv shows

     * @param tvPopularRequest request to fetch for popular tv shows
     */
    override fun doGetTvPopularApiCall(tvPopularRequest: TvPopularRequest): Observable<TvPopularResponse> {
        return mApiHelper.doGetTvPopularApiCall(tvPopularRequest)
    }

    /**
     * Get the tv shows that are on the air currently

     * @param tvOnTheAirRequest request for getting tv shows that are currently on the air
     */
    override fun doGetTvOnTheAirApiCall(tvOnTheAirRequest: TvOnTheAirRequest): Observable<TvOnTheAirResponse> {
        return mApiHelper.doGetTvOnTheAirApiCall(tvOnTheAirRequest)
    }

    /**
     * Get the tv shows that are airing today

     * @param tvAiringTodayRequest the request sent to the api to make the call
     * *
     * @return [&lt;TvAiringTodayResponse&gt;][Observable] object
     */
    override fun doGetTvAiringTodayApiCall(tvAiringTodayRequest: TvAiringTodayRequest): Observable<TvAiringTodayResponse> {
        return mApiHelper.doGetTvAiringTodayApiCall(tvAiringTodayRequest)
    }

    /**
     * Get the most newly created tv show. This is a live response and will continually change

     * @param tvLatestRequest the request that we will send out
     */
    override fun doGetTvLatestApiCall(tvLatestRequest: TvLatestRequest): Observable<TvLatestResponse> {
        return mApiHelper.doGetTvLatestApiCall(tvLatestRequest)
    }

    /**
     * checks and sees if this application has been started for the first time
     * Returns True if this is the first start, False otherwise

     * @return [Boolean]
     */
    override fun getFirstStart(): Boolean {
        return mPreferenceHelper.getFirstStart()
    }

    /**
     * Once the application has started for the first time, this will set the value to false
     * thus the app will start the splash screen activity when [.getFirstStart] is called

     * @param setFirstStart sets the value for the first start
     */
    override fun setFirstStart(setFirstStart: Boolean) {
        mPreferenceHelper.setFirstStart(setFirstStart)
    }

    override fun insertMovieNowPlayingItem(movieNowPlayingModel: MovieNowPlayingModel): Observable<Boolean> {
        return mDbHelper.insertMovieNowPlayingItem(movieNowPlayingModel)
    }

    override fun insertMovieNowPlayingItemList(movieNowPlayingModels: List<MovieNowPlayingModel>): Observable<Boolean> {
        return mDbHelper.insertMovieNowPlayingItemList(movieNowPlayingModels)
    }

    override fun insertMovieLatestItem(movieLatestModel: MovieLatestModel): Observable<Boolean> {
        return mDbHelper.insertMovieLatestItem(movieLatestModel)
    }

    override fun insertMoviePopularItem(moviePopularModel: MoviePopularModel): Observable<Boolean> {
        return mDbHelper.insertMoviePopularItem(moviePopularModel)
    }

    override fun insertMoviePopularItemList(moviePopularModels: List<MoviePopularModel>): Observable<Boolean> {
        return mDbHelper.insertMoviePopularItemList(moviePopularModels)
    }

    override fun insertMovieTopRatedItem(movieTopRatedModel: MovieTopRatedModel): Observable<Boolean> {
        return mDbHelper.insertMovieTopRatedItem(movieTopRatedModel)
    }

    override fun insertMovieTopRatedItemList(movieTopRatedModels: List<MovieTopRatedModel>): Observable<Boolean> {
        return mDbHelper.insertMovieTopRatedItemList(movieTopRatedModels)
    }

    override fun getNowPlayingMovieItem(movieNowPlayingId: Long): Observable<MovieNowPlayingModel> {
        return mDbHelper.getNowPlayingMovieItem(movieNowPlayingId)
    }

    override val movieNowPlayingItems: Observable<List<MovieNowPlayingModel>>
        get() = mDbHelper.movieNowPlayingItems

    override fun getMovieLatestItem(movieLatestModelId: Long): Observable<MovieLatestModel> {
        return mDbHelper.getMovieLatestItem(movieLatestModelId)
    }

    override fun getMoviePopularItem(moviePopularId: Long): Observable<MoviePopularModel> {
        return mDbHelper.getMoviePopularItem(moviePopularId)
    }

    override val moviePopularItemList: Observable<List<MoviePopularModel>>
        get() = mDbHelper.moviePopularItemList

    override fun getMovieTopRatedItem(movieTopRatedId: Long): Observable<MovieTopRatedModel> {
        return mDbHelper.getMovieTopRatedItem(movieTopRatedId)
    }

    override val movieTopRatedItemList: Observable<List<MovieTopRatedModel>>
        get() = mDbHelper.movieTopRatedItemList

    override fun updateNowPlayingMovieItem(movieNowPlayingModel: MovieNowPlayingModel): Observable<Boolean> {
        return mDbHelper.updateNowPlayingMovieItem(movieNowPlayingModel)
    }

    override fun updateMovieLatestItem(movieLatestModel: MovieLatestModel): Observable<Boolean> {
        return mDbHelper.updateMovieLatestItem(movieLatestModel)
    }

    override fun updateMoviePopularItem(moviePopularModel: MoviePopularModel): Observable<Boolean> {
        return mDbHelper.updateMoviePopularItem(moviePopularModel)
    }

    override fun updateMovieTopRatedItem(movieTopRatedModel: MovieTopRatedModel): Observable<Boolean> {
        return mDbHelper.updateMovieTopRatedItem(movieTopRatedModel)
    }

    override fun deleteNowPlayingMovieItem(movieNowPlayingId: Long): Observable<Long> {
        return mDbHelper.deleteNowPlayingMovieItem(movieNowPlayingId)
    }

    override fun deleteMovieNowPlayingItems(movieNowPlayingModels: List<MovieNowPlayingModel>): Observable<Int> {
        return mDbHelper.deleteMovieNowPlayingItems(movieNowPlayingModels)
    }

    override fun deleteMovieLatestItem(movieLatestId: Long): Observable<Boolean> {
        return mDbHelper.deleteMovieLatestItem(movieLatestId)
    }

    override fun deleteMoviePopularItem(moviePopularId: Long): Observable<Long> {
        return mDbHelper.deleteMoviePopularItem(moviePopularId)
    }

    override fun deleteMoviePopularItemList(moviePopularModels: List<MoviePopularModel>): Observable<Int> {
        return mDbHelper.deleteMoviePopularItemList(moviePopularModels)
    }

    override fun deleteMovieTopRatedItem(movieTopRatedId: Long): Observable<Long> {
        return mDbHelper.deleteMovieTopRatedItem(movieTopRatedId)
    }

    override fun deleteMovieTopRatedItemList(movieTopRatedModels: List<MovieTopRatedModel>): Observable<Int> {
        return mDbHelper.deleteMovieTopRatedItemList(movieTopRatedModels)
    }

    companion object {

        private val TAG = DataManagerImpl::class.java.simpleName
    }
}
