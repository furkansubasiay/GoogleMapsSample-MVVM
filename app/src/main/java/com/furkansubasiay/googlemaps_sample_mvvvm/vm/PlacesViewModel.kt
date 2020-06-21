package com.furkansubasiay.googlemaps_sample_mvvvm.vm


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import com.furkansubasiay.googlemaps_sample_mvvvm.network.Repository
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.adapter.ItemClickListener
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
class PlacesViewModel : BaseViewModel() {

    var repos: Repository

    val inputQuery = MutableLiveData<String>()
    val query: LiveData<String>?
        get() = inputQuery

    private val _resultsLiveData = MutableLiveData<PlacesResponce>()
    val results: LiveData<PlacesResponce>?
        get() = _resultsLiveData

    private val _selectedPlaceItemLiveData = MutableLiveData<PlaceItem>()
    val selectedPlaceItem: LiveData<PlaceItem>
        get() = _selectedPlaceItemLiveData

    private val _toolbarTitleLiveData = MutableLiveData<String>()
    val toolbarTitle: LiveData<String>?
        get() = _toolbarTitleLiveData


    init {
        repos = Repository()
        disposable = CompositeDisposable()
    }

    fun search(query: String) {
        disposable!!.add(repos.getPlaces(query.toString()).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->

                    if (result != null) {
                        _resultsLiveData.value = result
                    }
                },
                { error ->
                    Log.e("ERR","Error Message = "+ error.localizedMessage)
                }
            ))
    }


    fun setSelectedItem(placeItem: PlaceItem) {
        Log.e("furkan","Item Name = "+ placeItem.name)
        _selectedPlaceItemLiveData.value = placeItem
        _toolbarTitleLiveData.value = placeItem.name
    }




}