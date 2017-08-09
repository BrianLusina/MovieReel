package com.moviereel.ui.movie.nowplaying


import android.support.design.widget.Snackbar
import android.util.Log
import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * @author lusinabrian on 26/10/16.
 * * Description: presenter for now playing fragment that will handle fetching the data from api async
 * * and saving the data to the db for offline use and also adding the data to the adapter for the user to
 * * view.
 */

class MovieNPPresenterImpl<V : MovieNPView>
@Inject
constructor(
        mDataManager: DataManager,
        schedulerProvider: SchedulerProvider,
        mCompositeDisposable: CompositeDisposable)
    : BasePresenterImpl<V>(mDataManager, schedulerProvider, mCompositeDisposable), MovieNPPresenter<V> {

    /**
     * Implementation steps
     * Notes:
     * When the view is attached, a loading view will be displayed as the data is fetched in the background
     * During which the data will be saved for offline use and added to the adapter for display and
     * interaction with the user

     * After all that is completed successfully, the loading view will be destroyed and the user will
     * be able to interact with the recyclerview
     */
    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)

    }

    override fun onViewInitialized() {
        // is there network?, if true, we can retrieve from remote API
        // if(NetworkUtils.isNetworkAvailable())

        // else we can retrieve from local API

        // show loading
        // getBaseView().showSweetAlertLoadingProgress();

        // it is here that the data is fetched from the api and added to a database
        compositeDisposable.addAll(
                dataManager.getMoviesNowPlaying(true,1, "en-US")
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.newThread())
                        .subscribe({
                            // val movieNPModel = MovieNPEntity()
                            // add items to the list
//                            for (resultsResponse in movieNowPlayingResponses.results) {
//                                movieNPModel.moviePosterUrl = resultsResponse.posterPath
//                                movieNPModel.setIsAdult(resultsResponse.isAdult)
//                                movieNPModel.setAdult(resultsResponse.isAdult)
//                                movieNPModel.movieOverview = resultsResponse.overview
//                                movieNPModel.releaseDate = resultsResponse.releaseDate
//                                movieNPModel.movieId = resultsResponse.id
//                                movieNPModel.movieTitle = resultsResponse.title
//                                movieNPModel.originalTitle = resultsResponse.originalTitle
//                                movieNPModel.originalLang = resultsResponse.originalLanguage
//                                movieNPModel.movieBackdropUrl = resultsResponse.backdropPath
//                                movieNPModel.setMoviePopularity(resultsResponse.popularity)
//                                movieNPModel.movieVoteCount = resultsResponse.voteCount
//                                movieNPModel.isHasVideo = resultsResponse.isVideo
//                                movieNPModel.voteAverage = resultsResponse.voteAverage
//
//                                // update the database for offline use
//                                dataManager.insertMovieNowPlayingItem(movieNPModel)
//                                        .subscribe({ aBoolean ->
//                                            Log.d(TAG, if (aBoolean)
//                                                "accept: Database updated"
//                                            else
//                                                "accept: Database failed to update")
//                                        }) { throwable ->
//                                            Log.e(TAG, "accept: Error: " + throwable.message,
//                                                    throwable.cause)
//                                        }
//                            }

                            // update the recycler view
                            baseView?.updateMoviesNowPlaying(it)
                            // throw an error
                        }) { throwable ->
                            Log.e(TAG, "accept: " + throwable.message, throwable)

                            baseView?.showApiErrorSnackbar(R.string.snackbar_api_error,
                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
                        }
        )

        // dismiss the dialog
        // getBaseView().dismissSweetAlertLoadingProgress();
    }

    /**
     * Handles what will happen when the Fragment is resumed
     */
    override fun onResume() {

    }

    /**
     * picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item

     * @param bundleKey
     * *
     * @param movieList
     */
    override fun onItemClicked(bundleKey: String, movieList: List<MovieNPEntity>) {

    }

    /**
     * Handles what will happen when the Fragment is destroyed
     */
    override fun onDestroy() {

    }

    companion object {

        private val TAG = MovieNPPresenterImpl::class.java.simpleName
    }
}
