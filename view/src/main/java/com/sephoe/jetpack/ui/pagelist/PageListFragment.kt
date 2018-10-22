package com.sephoe.jetpack.ui.pagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.guill.coroutines.databinding.PageListFragmentBinding

class PageListFragment : androidx.fragment.app.Fragment() {

    private lateinit var viewModel: PageListViewModel
    private lateinit var binding: PageListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PageListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(PageListViewModel::class.java)
        binding.viewModel = viewModel
        val amount = PageListFragmentArgs.fromBundle(arguments).amount
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }
}