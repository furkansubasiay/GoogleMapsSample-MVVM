package com.furkansubasiay.googlemaps_sample_mvvvm.ui.map

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.ActivityMapsBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseActivity
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : BaseActivity<PlacesViewModel>(PlacesViewModel::class.java), OnMapReadyCallback {

    lateinit var binding : ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_maps)
        binding.lifecycleOwner = this
        actionbarInit(binding.toolbar,true)
        binding.viewModel = viewModel
        initMap()
    }

    private fun initMap(){
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.apply {
            observeData(map)
        }
    }
    private fun observeData(map: GoogleMap) {
        viewModel.selectedPlaceItem!!.observe(this@MapsActivity , Observer {
            addMarker(map,it)
        })
    }

    private fun addMarker(map: GoogleMap, placeItem: PlaceItem) {
        val itemPosition = LatLng(placeItem.geometry.location.latitude, placeItem.geometry.location.longitude)
        map.addMarker(
            MarkerOptions()
                .position(itemPosition)
                .title(placeItem.name)
        )
        zoomToPosition(map, itemPosition)
    }

    fun zoomToPosition(map: GoogleMap?, position: LatLng) {
        val cameraPosition = CameraPosition.Builder().target(position).zoom(ZOOM_LEVEL).build()
        map!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }


    companion object {
        private const val ZOOM_LEVEL = 14f
    }
}
