package com.moviereel.presentation.view.entertain.movie

import com.moviereel.presentation.view.base.BasePresenterImpl
import javax.inject.Inject

/**
 * @author lusinabrian
 * @notes: Presenter layer to interact with data and view
 */
class MoviesPresenterImpl<V : MovieFragView>
@Inject
constructor() : BasePresenterImpl<V>(), MoviesPresenter<V>
