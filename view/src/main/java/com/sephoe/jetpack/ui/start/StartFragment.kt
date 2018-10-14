package com.sephoe.jetpack.ui.start

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guill.coroutines.R
import com.example.guill.coroutines.databinding.StartFragmentBinding
import com.sephoe.jetpack.ui.adapter.StartOptionsAdapter
import com.sephoe.jetpack.ui.pagelist.PageListFragment
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)

        binding.viewModel = viewModel

        initOptions()
    }

    private fun initOptions() {
        rvStartOptions.setHasFixedSize(true)
        rvStartOptions.layoutManager = LinearLayoutManager(context)
        rvStartOptions.adapter = StartOptionsAdapter()
    }
}
