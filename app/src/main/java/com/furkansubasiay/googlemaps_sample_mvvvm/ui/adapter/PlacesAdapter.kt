package com.furkansubasiay.googlemaps_sample_mvvvm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.furkansubasiay.googlemaps_sample_mvvvm.BR
import com.furkansubasiay.googlemaps_sample_mvvvm.R
import com.furkansubasiay.googlemaps_sample_mvvvm.model.PlaceItem

/**
 * Created by FURKAN SUBAŞIAY on 2020-06-20.
 */

class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.ViewHolder> {

    private lateinit var placeItemList: MutableList<PlaceItem>
    private var listener: ItemClickListener<PlaceItem>? = null


    constructor() : super()

    constructor(list: MutableList<PlaceItem>, listener: ItemClickListener<PlaceItem>) : super() {
        this.placeItemList = list
        this.listener = listener
    }

    fun setList(list: MutableList<PlaceItem>) {
        placeItemList = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(viewGroup.context), R.layout.item_place, viewGroup, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (getItem(position) != null) {
            val item = getItem(position)
            holder.binding.setVariable(BR.viewModel, item)

            if (listener != null)
                holder.binding.setVariable(BR.clickListener, listener)

            holder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return if (::placeItemList.isInitialized) placeItemList.size else 0
    }

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    fun getItem(index: Int): PlaceItem? {
        return if (index < placeItemList.size) placeItemList[index] else null
    }


    /* fun addAll(list: MutableList<PlaceItem>) {
         if (::placeItemList.isInitialized.not())
             placeItemList = arrayListOf()
         placeItemList.addAll(list)
         notifyDataSetChanged()
     }*/

}