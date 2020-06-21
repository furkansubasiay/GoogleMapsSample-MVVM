package com.furkansubasiay.googlemaps_sample_mvvvm.ui.map


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer

import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.FragmentMapsBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseFragment
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.detail.DetailFragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.include_toolbar.view.toolbar


class MapsFragment : BaseFragment(), OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener {


    var rootView:View?=null
    lateinit var binding: FragmentMapsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_maps, container, false)
        rootView = binding.root
        binding.lifecycleOwner = this
        binding.toolbar.toolbar.setTitle(context!!.resources.getString(R.string.title_maps))
        binding.viewModel = viewModel
        initMap()
        return rootView
    }
    private fun initMap(){
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        map?.apply {
            observeData(map)
        }
    }
    private fun observeData(map: GoogleMap) {

        viewModel.selectedPlaceItem!!.observe(this , Observer {
            addMarker(map,it)
        })
    }

    private fun addMarker(map: GoogleMap, placeItem: PlaceItem) {
        val itemPosition = LatLng(placeItem.geometry!!.location.latitude, placeItem.geometry!!.location.longitude)
        map.addMarker(
            MarkerOptions()
                .position(itemPosition)
                .title(placeItem.name)
        )
        map.setOnInfoWindowClickListener(this)
        zoomToPosition(map, itemPosition)
    }

    fun zoomToPosition(map: GoogleMap?, position: LatLng) {
        val cameraPosition = CameraPosition.Builder().target(position).zoom(ZOOM_LEVEL).build()
        map!!.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onInfoWindowClick(p0: Marker?) {
        changeFragment()
    }

    private fun changeFragment() {
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.frame_layout, DetailFragment())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        private const val ZOOM_LEVEL = 14f
    }

}
