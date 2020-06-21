package com.furkansubasiay.googlemaps_sample_mvvvm.ui.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.furkansubasiay.googlemaps_sample_mvvvm.databinding.IncludeToolbarBinding
import com.furkansubasiay.googlemaps_sample_mvvvm.util.Utils


/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */
@SuppressLint("Registered")
open class BaseActivity :AppCompatActivity() {



    protected fun actionbarInit(includeToolbar: IncludeToolbarBinding,title:String, isEnableNavi: Boolean) {
        setSupportActionBar(includeToolbar.toolbar)
        setTitle(title)
        if (isEnableNavi) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            includeToolbar.toolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        }
    }

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