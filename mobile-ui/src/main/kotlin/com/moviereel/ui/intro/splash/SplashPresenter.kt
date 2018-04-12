package com.moviereel.ui.intro.splash

import com.moviereel.di.scopes.PerActivity
import com.moviereel.ui.base.BasePresenter

/**
 * @author lusinabrian on 01/04/17
 */

@PerActivity
interface SplashPresenter<V : SplashView> : BasePresenter<V>
