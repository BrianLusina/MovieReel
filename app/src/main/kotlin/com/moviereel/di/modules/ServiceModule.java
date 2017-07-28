package com.moviereel.di.modules;

import android.app.Service;

import dagger.Module;

/**
 * @author lusinabrian on 27/03/17
 */

@Module
public class ServiceModule {

    private final Service mService;

    public ServiceModule(Service mService){
        this.mService = mService;
    }


}
