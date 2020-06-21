package com.furkansubasiay.googlemaps_sample_mvvvm.network

import com.furkansubasiay.googlemaps_sample_mvvvm.BuildConfig
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import com.google.gson.GsonBuilder
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
interface Service {

    @GET(" place/textsearch/json")
   suspend fun getPlaces(@Query("query") query:String, @Query("key") key:String): Response<PlacesResponce>


    companion object{


            fun create(): Service {
                val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .build()
                return retrofit.create(Service::class.java)

        }
    }
}