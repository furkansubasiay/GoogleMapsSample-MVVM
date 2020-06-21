package com.furkansubasiay.googlemaps_sample_mvvvm.network

import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import io.reactivex.Single

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */

class Repository{

    val serviceClient by lazy {
        Api.create()
    }

    fun getPlaces(text:String): Single<PlacesResponce> {
        return serviceClient.getPlaces(text,"AIzaSyCPWJdSXcwnH4nSduZasxeTM6JFCXILu_k")
    }

}