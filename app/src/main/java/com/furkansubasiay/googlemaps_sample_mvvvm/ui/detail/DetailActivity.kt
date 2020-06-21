package com.furkansubasiay.googlemaps_sample_mvvvm.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.ActivityDetailBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.base.BaseActivity
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel

class DetailActivity : BaseActivity<PlacesViewModel>(PlacesViewModel::class.java) {

    lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this
        actionbarInit(binding.toolbar,true)
        binding.viewModel = viewModel
    }
}
