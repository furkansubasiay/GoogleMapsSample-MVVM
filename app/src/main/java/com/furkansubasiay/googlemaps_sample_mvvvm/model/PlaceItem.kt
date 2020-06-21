package com.furkansubasiay.googlemaps_sample_mvvvm.model

import com.google.gson.annotations.SerializedName

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */

data class PlaceItem(
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("geometry") val geometry: Geometry?,
    @SerializedName("formatted_address") val address: String?,
    @SerializedName("icon") val iconUrl: String?
)

data class Geometry(
    @SerializedName("location") val location: Location
)

data class  Location(
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lng") val longitude: Double
)