package com.furkansubasiay.googlemaps_sample_mvvvm.ui.base

import android.app.ProgressDialog
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.IncludeToolbarBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.util.Utils
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.PlacesViewModel

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-21.
 */
open class BaseFragment:Fragment() {

    protected val viewModel: PlacesViewModel by lazy { ViewModelProviders.of(activity!!).get(
        PlacesViewModel::class.java) }

    var progressDialog: ProgressDialog? = null

    fun showLoading(context: Context) {

        if(progressDialog==null)
        {
            progressDialog = Utils.showLoadingDialog(context)
        }

        if(progressDialog!=null && !progressDialog!!.isShowing)
        {
            progressDialog!!.show()
        }
    }


    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog!!.isShowing) {
                progressDialog!!.dismiss()
            }
        }
    }
}