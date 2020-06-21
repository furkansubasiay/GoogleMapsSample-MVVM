package com.furkansubasiay.googlemaps_sample_mvvvm.ui.detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.FragmentDetailBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseFragment


class DetailFragment : BaseFragment() {

    var rootView: View? = null
    lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        rootView = binding.root
        binding.lifecycleOwner = this
        //actionbarInit(binding.toolbar,applicationContext.resources.getString(R.string.title_detail), true)
        binding.toolbar.toolbar.title=context!!.resources.getString(R.string.title_detail)
        binding.viewModel = viewModel
        return rootView

    }


}
