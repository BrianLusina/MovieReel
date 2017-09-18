package com.moviereel.data

import com.moviereel.data.api.model.BaseResultsResponse
import com.moviereel.data.api.model.movie.response.MovieNPResponse
import com.moviereel.data.api.model.movie.response.MoviePopularResponse
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.db.entities.movie.MoviePEntity
import com.moviereel.data.db.entities.movie.MovieTREntity
import com.moviereel.data.files.FileHelper
import com.moviereel.data.prefs.PreferencesHelper
import com.moviereel.data.repositories.RepositoryHelper
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author lusinabrian on 28/03/17
 * * [Singleton] indicates that there will only be one object of this in the entire application
 * * thus ensuring that the app does not have several objects that will interact with the Model layer
 * * of the application
 * * The constructor is annoted with [Inject] to instruct dagger to accumulate all the param
 * * dependencies when class is being constructed
 * Constructor for the DataMangerImpl. This will create a new object of this class with the
 * following params
 * @param mFileHelper interface when interacting with the File helper class for interacting
 * with files
 * @param mPreferenceHelper preference interface when interacting with the preference layer
 * of the application when storing data persistently in [android.content.SharedPreferences]
 * */

@Singleton
class DataManagerImpl
@Inject
constructor(
        val mPreferenceHelper: PreferencesHelper,
        val mFileHelper: FileHelper,
        val mRepositoryHelper: RepositoryHelper) : DataManager {

    /**
     * performs a call to get Now Playing Movies
     * Will return a response that will contain a list of all the Movies that are currently now playing
     * @return [MovieNPResponse] response to return from the api call
     */
    override fun getMoviesNowPlaying(remote: Boolean?, page: Int, language: String): Flowable<List<MovieNPEntity>> {
        return mRepositoryHelper.getMoviesNowPlaying(remote, page, language)
    }


    /**
     * API call to get the latest movies being shown*/
    override fun doGetMoviesLatest(remote: Boolean, language: String): Observable<BaseResultsResponse.MovieLatestResponse> {
        return mRepositoryHelper.doGetMoviesLatest(remote, language)
    }

    /**
     * Does an api call to get a list of popular movies
     * @return A list of [MoviePopularResponse] we get from the api call
     */
    override fun doGetMoviesPopular(remote: Boolean, page: Int, language: String): Flowable<List<MoviePEntity>> {
        return mRepositoryHelper.doGetMoviesPopular(remote, page, language)
    }

    override fun doGetMoviesTopRated(remote: Boolean, page: Int, language: String, region: String): Flowable<List<MovieTREntity>> {
        return mRepositoryHelper.doGetMoviesTopRated(remote, page, language, region)
    }

    /******************************PREFERENCES**********************************************/

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
}
