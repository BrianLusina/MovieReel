package com.moviereel.presentation.view.entertain.movie.popular

import com.moviereel.presentation.view.entertain.base.EntertainPageBasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class PopularPresenterImpl<V : PopularView>
@Inject
constructor()
    : EntertainPageBasePresenterImpl<V>(),
        PopularPresenter<V> {

    override fun onAttach(mBaseView: V) {
        super.onAttach(mBaseView)
    }

    override fun onResume() {
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

    private fun fetchPopularMovies(page: Int) {
//        compositeDisposable.addAll(
//                dataManager.doGetMoviesPopular(remote, page, "en-US")
//                        .observeOn(schedulerProvider.ui())
//                        .subscribeOn(schedulerProvider.newThread())
//                        .debounce(10000, TimeUnit.MILLISECONDS)
//                        .subscribe({
//                            // update the recycler view
//                            baseView.updatePopularMovies(it)
//                            baseView.stopSwipeRefresh()
//                        }, {
//                            // on error
//                            error("Error fetching popular movies ${it.message}", it)
//                            baseView.showApiErrorSnackbar(R.string.snackbar_api_error,
//                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
//                        }, {
//                            // on complete
//                        })
//        )
//        // stop swipe refresh
//        baseView.stopSwipeRefresh()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onDestroy() {
    }

}
