package com.sephoe.jetpack.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.guill.coroutines.databinding.StartOptionsItemBinding
import com.sephoe.domain.options.OptionsEntity

class StartOptionsAdapter(
        private val _options: MutableList<OptionsEntity> = mutableListOf()
) : androidx.recyclerview.widget.RecyclerView.Adapter<StartOptionsAdapter.OptionsViewHolder>() {

    // RecyclerView functions

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OptionsViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding = StartOptionsItemBinding.inflate(inflater)
        return OptionsViewHolder(binding)
    }

    override fun getItemCount(): Int = _options.size

    override fun onBindViewHolder(p0: OptionsViewHolder, p1: Int) {
        p0.binding.options = _options[p1]
        p0.binding.executePendingBindings()
    }


    //----------------------------------------------------------------------------------------------
    // ViewHolder

    inner class OptionsViewHolder(val binding: StartOptionsItemBinding) : androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)


    //----------------------------------------------------------------------------------------------
    // Public functions

    fun update(p0: List<OptionsEntity>) {
        _options.clear()
        _options.addAll(p0)

        notifyDataSetChanged()
    }
}