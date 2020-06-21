package com.furkansubasiay.googlemaps_sample_mvvvm.ui.place

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.FragmentPlaceSearchBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.adapter.ItemClickListener
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.adapter.PlacesAdapter
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseFragment
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.map.MapsFragment
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel


class PlaceSearchFragment : BaseFragment(),ItemClickListener<PlaceItem> {

    var rootView:View?=null
    lateinit var binding: FragmentPlaceSearchBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PlacesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_place_search, container, false)
        rootView = binding.root
        init()
        observeData()
        return rootView
    }
    fun init(){
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        recyclerView = binding.searchList
        recyclerView.setLayoutManager(LinearLayoutManager(this.context))
        recyclerView.setHasFixedSize(true)
        adapter = PlacesAdapter(arrayListOf(), this)
        recyclerView.adapter =adapter
    }

    override fun onClick(item: PlaceItem) {
        viewModel.setSelectedItem(item)
        changeFragment()
    }

    private fun observeData() {
        viewModel.query!!.observe(this, Observer {
            if (it.length > 1) viewModel.search(it)
        })

        viewModel.results!!.observe(this, Observer {
            if (it != null && it.status.equals(STATUS_OK)) {
                it.places?.let { places -> adapter.setList(places) }
            }
        })
    }
    private fun changeFragment() {

        activity!!.supportFragmentManager.beginTransaction().replace(R.id.frame_layout, MapsFragment())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        const val STATUS_OK = "OK"
        const val STATUS_REQUEST_DENIED = "REQUEST_DENIED"
    }

}
