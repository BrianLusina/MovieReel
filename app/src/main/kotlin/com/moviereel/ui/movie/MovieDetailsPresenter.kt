package com.moviereel.ui.movie

import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.base.BasePresenter

/**
 * @author lusinabrian on 10/06/17.
 * @Notes Presenter for interacting with Model layout
 */

@PerActivity
interface MovieDetailsPresenter<V : MovieDetailsView> : BasePresenter<V>{
}