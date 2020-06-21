package com.furkansubasiay.googlemaps_sample_mvvvm.ui.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.IncludeToolbarBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.util.Utils
import com.furkansubasiay.googlemaps_sample_mvvvm.vm.base.BaseViewModel

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
@SuppressLint("Registered")
open class BaseActivity<VM: BaseViewModel>(private var viewModelClass: Class<VM>) :AppCompatActivity() {

    protected val viewModel:VM by lazy { ViewModelProviders.of(this, viewModelFactory).get(viewModelClass) }

    protected fun actionbarInit(includeToolbar: IncludeToolbarBinding, isEnableNavi: Boolean) {
        setSupportActionBar(includeToolbar.toolbar)
        if (isEnableNavi) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            includeToolbar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

    var progressDialog: ProgressDialog? = null
    internal lateinit var viewModelFactory: ViewModelProvider.Factory
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