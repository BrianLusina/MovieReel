package com.moviereel.ui.entertain.movie.upcoming

import android.support.design.widget.Snackbar
import com.moviereel.R
import com.moviereel.data.DataManager
import com.moviereel.data.io.SchedulerProvider
import com.moviereel.ui.base.BasePresenterImpl
import com.moviereel.ui.entertain.base.EntertainPageBasePresenterImpl
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.error
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MovieUpcomingPresenterImpl<V : MovieUpcomingView>
@Inject
constructor(mDataManager: DataManager, mCompositeDisposable: CompositeDisposable,
            mSchedulerProvider: SchedulerProvider) : EntertainPageBasePresenterImpl<V>(mDataManager,
        mSchedulerProvider, mCompositeDisposable),
        MovieUpcomingPresenter<V> {

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
        compositeDisposable.addAll(
                dataManager.doGetMoviesUpcoming(remote, page, "en-US", "")
                        .observeOn(schedulerProvider.ui())
                        .subscribeOn(schedulerProvider.newThread())
                        .debounce(10000, TimeUnit.MILLISECONDS)
                        .subscribe({
                            // update the recycler view
                            baseView.updateMoviesUpcoming(it)
                            baseView.stopSwipeRefresh()
                        }, {
                            // on error

                            error("Error fetching now playing resources ${it.message}", it)
                            baseView.showApiErrorSnackbar(R.string.snackbar_api_error,
                                    R.string.snackbar_api_error_retry, Snackbar.LENGTH_LONG)
                        },{
                            // on complete
                        })
        )
        // stop swipe refresh
        baseView.stopSwipeRefresh()
    }

    /**
     * Handles what will happen when the Fragment is resumed
     */
    override fun onResume() {

    }
    override fun onDetach() {
        super.onDetach()
        compositeDisposable.dispose()
    }
}
