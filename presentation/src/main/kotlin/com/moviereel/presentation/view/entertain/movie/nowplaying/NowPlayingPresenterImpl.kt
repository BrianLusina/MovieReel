package com.moviereel.presentation.view.entertain.movie.nowplaying


import com.moviereel.domain.interactors.SingleUseCase
import com.moviereel.domain.interactors.movies.nowplaying.GetMoviesNowPlayingList
import com.moviereel.domain.models.movies.MovieNowPlayingDomainModel
import com.moviereel.presentation.mapper.movies.NowPlayingPresenterMapper
import com.moviereel.presentation.view.entertain.base.EntertainPageBasePresenterImpl
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject


/**
 * @author lusinabrian on 26/10/16.
 * * Description: presenter for now playing fragment that will handle fetching the data from api async
 * * and saving the data to the db for offline use and also adding the data to the adapter for the user to
 * * view.
 */

class NowPlayingPresenterImpl<V : NowPlayingView>
@Inject
constructor(
        val getMoviesNowPlayingUseCase: SingleUseCase<List<MovieNowPlayingDomainModel>, GetMoviesNowPlayingList.Params>,
        val nowPlayingPresenterMapper: NowPlayingPresenterMapper) :
        EntertainPageBasePresenterImpl<V>(), NowPlayingPresenter<V> {

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
        getMoviesNowPlayingUseCase.execute(Subscriber(), GetMoviesNowPlayingList.Params(page, "eng"))
    }

    /**
     * Handles what will happen when the Fragment is resumed
     */
    override fun onResume() {
        fetchFromApi(1)
    }

    override fun onDestroy() {
        getMoviesNowPlayingUseCase.dispose()
    }

    /**
     * picks the data of the item clicked in the RecyclerView
     * start activity for the clicked movie item
     * @param bundleKey
     * @param movieList
     */
//    override fun onItemClicked(bundleKey: String, movieList: List<MovieNowPlayingEntity>) {
//
//    }

    inner class Subscriber: DisposableSingleObserver<List<MovieNowPlayingDomainModel>>() {

        override fun onSuccess(movieNowPlayingList: List<MovieNowPlayingDomainModel>) {
            if(movieNowPlayingList.isNotEmpty()){
                baseView.updateMoviesNowPlaying(
                        movieNowPlayingList.map {
                            nowPlayingPresenterMapper.mapToView(it)
                        })
                baseView.stopSwipeRefresh()
            } else {
                baseView.onErrorSnackBar()
            }
        }

        override fun onError(exception: Throwable) {
           baseView.showApiErrorSnackbar()
        }
    }
}
