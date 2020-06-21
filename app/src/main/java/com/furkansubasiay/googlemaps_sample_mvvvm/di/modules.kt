package com.furkansubasiay.googlemaps_sample_mvvvm.di

import com.furkansubasiay.googlemaps_sample_mvvvm.network.Repository
import com.furkansubasiay.googlemaps_sample_mvvvm.network.Service
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-21.
 */

val networkModule = module {
    single { Service }
    single { Repository() }
}

val viewModelModule = module {

    viewModel { PlacesViewModel() }

}