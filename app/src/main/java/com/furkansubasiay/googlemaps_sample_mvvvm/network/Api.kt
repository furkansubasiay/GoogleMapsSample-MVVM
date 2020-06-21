package com.furkansubasiay.googlemaps_sample_mvvvm.network

import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
interface Api {

    @GET(" place/textsearch/json")
    fun getPlaces(@Query("query") query:String, @Query("key") key:String): Single<PlacesResponce>


    companion object{
        const val BASE_URL="https://maps.googleapis.com/maps/api/"

            fun create(): Api {
                val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                return retrofit.create(Api::class.java)

        }
    }
}