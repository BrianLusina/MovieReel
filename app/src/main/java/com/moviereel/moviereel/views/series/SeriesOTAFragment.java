package com.moviereel.moviereel.views.series;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Project: MovieReel
 * Package: com.moviereel.moviereel.views.series
 * Created by lusinabrian on 09/09/16 at 22:25
 * Description:
 */
public class SeriesOTAFragment extends Fragment{


    /*required empty constructor*/
    public SeriesOTAFragment(){}

    /**Initialize thr fragment*/
    public static Fragment newInstance() {
        SeriesOTAFragment fragment = new SeriesOTAFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /*END*/
}
