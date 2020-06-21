package com.furkansubasiay.googlemaps_sample_mvvvm.network

import com.furkansubasiay.googlemaps_sample_mvvvm.BuildConfig
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import org.koin.core.KoinComponent
import retrofit2.Response

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */

class Repository : KoinComponent {

    val serviceClient by lazy {
        Service.create()
    }

    suspend fun getPlaces(text:String): Response<PlacesResponce> {
        return serviceClient.getPlaces(text,BuildConfig.API_KEY_VALUE)
    }

}