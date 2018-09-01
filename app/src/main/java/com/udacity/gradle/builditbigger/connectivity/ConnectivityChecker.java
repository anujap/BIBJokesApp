package com.udacity.gradle.builditbigger.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * This class checks for the connectivity
 */
public class ConnectivityChecker {

    public static boolean isConnectivityAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
