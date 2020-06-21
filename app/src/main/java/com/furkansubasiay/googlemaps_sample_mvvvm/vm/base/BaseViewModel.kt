package com.furkansubasiay.googlemaps_sample_mvvvm.vm.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
open class BaseViewModel:ViewModel() {
    protected var disposable: CompositeDisposable? = null

    override fun onCleared() {
        if (disposable != null) {
            disposable!!.clear();
            disposable = null;
        }
        super.onCleared()
    }
}