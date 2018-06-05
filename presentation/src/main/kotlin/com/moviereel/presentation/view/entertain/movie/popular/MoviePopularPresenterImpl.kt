package com.moviereel.presentation.view.entertain.movie.popular

import android.support.design.widget.Snackbar
import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.entertain.base.EntertainPageBasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MoviePopularPresenterImpl<V : MoviePopularView>
@Inject
constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable,
            mSchedulerProvider: SchedulerProvider)
    : EntertainPageBasePresenterImpl<V>(mDataManager, mSchedulerProvider, mCompositeDisposable),
        MoviePopularPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    // the first initialization will be to page 1
    override fun onViewInitialized() {
        fetchPopularMovies(1)
    }

    override fun onLoadMoreFromApi(page: Int) {
        fetchPopularMovies(page)
    }

    override fun onSwipeRefreshTriggered() {
        fetchPopularMovies(1)
    }

    /**
     * */
    private fun fetchPopularMovies(page: Int) {
        compositeDisposable.addAll(
                dataManager.doGetMoviesPopular(remote, page, "en-US")
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.newThread())
                        .debounce(10000, TimeUnit.MILLISECONDS)
                        .subscribe({
                            // update the recycler view
                            baseView.updatePopularMovies(it)
                            baseView.stopSwipeRefresh()
                        }, {
                            // on error
                            error("Error fetching popular movies ${it.message}", it)
                            baseView.showApiErrorSnackbar(R.string.snackbar_api_error,
                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
                        }, {
                            // on complete
                        })
        )
        // stop swipe refresh
        baseView.stopSwipeRefresh()
    }

    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }
}
