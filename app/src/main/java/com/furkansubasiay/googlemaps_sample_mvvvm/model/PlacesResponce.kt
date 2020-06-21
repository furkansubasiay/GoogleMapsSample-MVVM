package com.furkansubasiay.googlemaps_sample_mvvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
data class PlacesResponce(
    @SerializedName("status") var status:String?,
    @SerializedName("results") var places :ArrayList<PlaceItem>?
)