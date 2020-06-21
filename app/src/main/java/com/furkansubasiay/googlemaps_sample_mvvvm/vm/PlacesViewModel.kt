package com.furkansubasiay.googlemaps_sample_mvvvm.vm


import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlacesResponce
import com.furkansubasiay.googlemaps_sample_mvvvm.network.Repository
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.adapter.ItemClickListener
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
       viewModelScope.launch(Dispatchers.Default) {
           val response = repos.getPlaces(query.toString())
           if(response.isSuccessful)
           {
               _resultsLiveData.postValue(response.body())
           }
           else
           {
               Log.e("ERROR","MESSAGE = "+ response.message())
           }
        }
    }


    fun setSelectedItem(placeItem: PlaceItem) {
        _selectedPlaceItemLiveData.value = placeItem
        _toolbarTitleLiveData.value = placeItem.name
    }




}