package com.furkansubasiay.googlemaps_sample_mvvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.ui.place.PlaceSearchFragment

class RootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_root)

        supportFragmentManager.beginTransaction().add(R.id.frame_layout, PlaceSearchFragment())
            .commit()

    }
}
