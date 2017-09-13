package com.moviereel.ui.entertain.movie.nowplaying


import android.support.design.widget.Snackbar
import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.data.db.entities.movie.MovieNPEntity
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import com.moviereel.ui.entertain.base.EntertainPageBasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.error
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * @author lusinabrian on 26/10/16.
 * * Description: presenter for now playing fragment that will handle fetching the data from api async
 * * and saving the data to the db for offline use and also adding the data to the adapter for the user to
 * * view.
 */

class MovieNPPresenterImpl<V : MovieNPView>
@Inject
constructor(mDataManager: DataManager, schedulerProvider: SchedulerProvider,
            mCompositeDisposable: CompositeDisposable)
    : EntertainPageBasePresenterImpl<V>(mDataManager, schedulerProvider, mCompositeDisposable), MovieNPPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    // the first initialization will be to page 1
    override fun onViewInitialized() {
        fetchFromApi(1)
    }

    override fun onLoadMoreFromApi(page: Int) {
        fetchFromApi(page)
    }

    override fun onSwipeRefreshTriggered() {
        fetchFromApi(1)
    }

    private fun fetchFromApi(page: Int) {
        val remote = baseView?.isNetworkConnected
        compositeDisposable.addAll(
                dataManager.getMoviesNowPlaying(remote, page, "en-US")
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.newThread())
                        .debounce(10000, TimeUnit.MILLISECONDS)
                        .subscribe({
                            // update the recycler view
                            baseView?.updateMoviesNowPlaying(it)
                            baseView?.stopSwipeRefresh()
                        }, {
                            // on error

                            error("Error fetching now playing resources ${it.message}", it)
                            baseView?.showApiErrorSnackbar(R.string.snackbar_api_error,
                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
                        },{
                            // on complete
                        })
        )
        // stop swipe refresh
        baseView?.stopSwipeRefresh()
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
        super.onDestroy()
    }
}
