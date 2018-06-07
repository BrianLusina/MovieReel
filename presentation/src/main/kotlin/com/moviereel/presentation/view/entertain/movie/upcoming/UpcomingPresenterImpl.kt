package com.moviereel.presentation.view.entertain.movie.upcoming

import com.moviereel.presentation.view.entertain.base.EntertainPageBasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class UpcomingPresenterImpl<V : UpcomingView>
@Inject
constructor() : EntertainPageBasePresenterImpl<V>(),
        UpcomingPresenter<V> {

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
//        compositeDisposable.addAll(
//                dataManager.doGetMoviesUpcoming(remote, page, "en-US", "")
//                        .observeOn(schedulerProvider.ui())
//                        .subscribeOn(schedulerProvider.newThread())
//                        .debounce(10000, TimeUnit.MILLISECONDS)
//                        .subscribe({
//                            // update the recycler view
//                            baseView.updateMoviesUpcoming(it)
//                            baseView.stopSwipeRefresh()
//                        }, {
//                            // on error
//
//                            error("Error fetching now playing resources ${it.message}", it)
//                            baseView.showApiErrorSnackbar(R.string.snackbar_api_error,
//                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
//                        },{
//                            // on complete
//                        })
//        )
//        // stop swipe refresh
//        baseView.stopSwipeRefresh()
    }

    /**
     * Handles what will happen when the Fragment is resumed
     */
    override fun onResume() {

    }

    override fun onDestroy() {
    }

}
