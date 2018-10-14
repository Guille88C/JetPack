package com.sephoe.jetpack.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guill.coroutines.R
import kotlinx.android.synthetic.main.start_options_item.view.*

class StartOptionsAdapter : RecyclerView.Adapter<StartOptionsAdapter.OptionsViewHolder>() {

    // Attributes

    private val _options = mutableListOf<String>()


    //----------------------------------------------------------------------------------------------
    // RecyclerView functions

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OptionsViewHolder {
        return OptionsViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.start_options_item, p0, false))
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(p0: OptionsViewHolder, p1: Int) {
        p0.itemView.tvOptionsItemOption.text = "Option $p1"
    }


    //----------------------------------------------------------------------------------------------
    // ViewHolder

    inner class OptionsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}