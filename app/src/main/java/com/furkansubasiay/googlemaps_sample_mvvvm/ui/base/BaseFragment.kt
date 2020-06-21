package com.furkansubasiay.googlemaps_sample_mvvvm.ui.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.IncludeToolbarBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-21.
 */
open class BaseFragment:Fragment() {
    protected val viewModel: PlacesViewModel by lazy { ViewModelProviders.of(activity!!).get(
        PlacesViewModel::class.java) }

}