package com.furkansubasiay.googlemaps_sample_mvvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.furkansubasiay.googlemaps_sample_mvvvm.network.Repository
import java.security.Provider

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(private val repository: Repository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PlacesViewModel::class.java)) {
            PlacesViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}