package com.furkansubasiay.googlemaps_sample_mvvvm.network

import com.furkansubasiay.googlemaps_sample_mvvvm.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */


class RequestInterceptor constructor() : Interceptor {

        //TODO  API_KEY Stringden||buildConfigden alınacak
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        val httpUrl = request.url.newBuilder()
            .addQueryParameter(API_KEY_QUERY, "AIzaSyCvPb9i9d_y9dgwJIFokQo0lbdWxTSWCK0")
            .build()

        request = request.newBuilder().url(httpUrl).build()

        return chain.proceed(request)
    }

    companion object {
        const val API_KEY_QUERY = "key"
    }
}