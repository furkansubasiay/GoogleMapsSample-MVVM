package com.furkansubasiay.googlemaps_sample_mvvvm.vm


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.base.BaseViewModel

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
class PlacesViewModel: BaseViewModel() {
    var inputQuery = MutableLiveData<String>()
    val query :LiveData<String>?
            get()= inputQuery

    private val _resultsLiveData = MutableLiveData<PlacesResponce>()
    val results: LiveData<PlacesResponce>?
        get() = _resultsLiveData

    private val _selectedPlaceItemLiveData = MutableLiveData<PlaceItem>()
    val selectedPlaceItem: LiveData<PlaceItem>?
        get() = _selectedPlaceItemLiveData

    private val _toolbarTitleLiveData = MutableLiveData<String>()
    val toolbarTitle: LiveData<String>?
        get() = _toolbarTitleLiveData

    init {

    }

    fun search(query:String){

    }

    fun setSelectedItem(placeItem: PlaceItem){
        _selectedPlaceItemLiveData.value = placeItem
        _toolbarTitleLiveData.value = placeItem.name
    }

}