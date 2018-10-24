package com.sephoe.jetpack.ui.pagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.guill.coroutines.databinding.PageListFragmentBinding

class PageListFragment : androidx.fragment.app.Fragment() {

    // Attributes

    private lateinit var viewModel: PageListViewModel
    private lateinit var binding: PageListFragmentBinding

    //----------------------------------------------------------------------------------------------
    // Fragment

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PageListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PageListViewModel::class.java)
        binding.viewModel = viewModel

        init()
        initObservers()
    }

    private fun init() {
        val amount = PageListFragmentArgs.fromBundle(arguments).amount
        viewModel.amount = amount
    }

    private fun initObservers() {
        viewModel.clickLiveEvent.observe(this, Observer {
            val action = PageListFragmentDirections.actionPageListFragmentToStartFragment()
            NavHostFragment.findNavController(this).navigate(action)

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

}