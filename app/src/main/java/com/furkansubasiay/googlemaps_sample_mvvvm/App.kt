package com.furkansubasiay.googlemaps_sample_mvvvm

import android.app.Application
import com.furkansubasiay.googlemaps_sample_mvvvm.di.networkModule
import com.furkansubasiay.googlemaps_sample_mvvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
class App :Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, viewModelModule))
        }
    }

}