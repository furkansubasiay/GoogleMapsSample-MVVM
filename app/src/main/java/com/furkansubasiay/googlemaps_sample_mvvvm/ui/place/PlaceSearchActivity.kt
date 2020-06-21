package com.furkansubasiay.googlemaps_sample_mvvvm.ui.place

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.ActivityPlaceSearchBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseActivity
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel

class PlaceSearchActivity : BaseActivity<PlacesViewModel>(PlacesViewModel::class.java) {

    lateinit var listView: RecyclerView
    lateinit var binding: ActivityPlaceSearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_place_search)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.query!!.observe(this, Observer {
           if(it.length>1) viewModel.search(it)
        })

        viewModel.results!!.observe(this, Observer {
            if(it!=null&&it.status.equals(STATUS_OK)){

            }
        })

    }

    companion object{
        const val STATUS_OK="OK"
    }
}
