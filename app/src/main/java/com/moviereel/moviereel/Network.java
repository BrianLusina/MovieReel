package com.moviereel.moviereel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Project: Movie Reel
 * Package: com.moviereel.moviereel
 * Created by lusinabrian on 26/08/16 at 09:44
 * <p/>
 * Description: checks for network status
 */
public class Network {

    /**
     Method to check network availability
     Using ConnectivityManager to check for Network Connection
     * */
    public boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

}
