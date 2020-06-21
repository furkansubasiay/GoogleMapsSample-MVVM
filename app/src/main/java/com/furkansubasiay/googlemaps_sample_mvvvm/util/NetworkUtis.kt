package com.furkansubasiay.googlemaps_sample_mvvvm.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.widget.Toast
import com.furkansubasiay.googlemaps_sample_mvvvm.R

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
class NetworkUtils {
    companion object{

        @Suppress("DEPRECATION")
        fun isInternetAvailable(context: Context): Boolean {
            var result = false
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cm?.run {
                    cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                        result = when {
                            hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                            hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                            else -> false
                        }
                    }
                }
            } else {
                cm?.run {
                    cm.activeNetworkInfo?.run {
                        if (type == ConnectivityManager.TYPE_WIFI) {
                            result = true
                        } else if (type == ConnectivityManager.TYPE_MOBILE) {
                            result = true
                        }
                    }
                }
            }
            return result
        }

        fun showConnectionAlert(context: Context)
        {
            Toast.makeText(context,context.getString(R.string.no_connection_message), Toast.LENGTH_LONG).show()
        }
    }
}