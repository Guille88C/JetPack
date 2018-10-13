package com.sephoe.jetpack.ui.start

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guill.coroutines.R
import com.example.guill.coroutines.databinding.StartFragmentBinding
import com.sephoe.jetpack.ui.pagelist.PageListFragment
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : Fragment(), StartView {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // start_fragment
        binding = StartFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        viewModel.view = this
        viewModel.nameLiveData.observe(this, Observer { item ->
            tvStartName.text = item
        })

        binding.viewModel = viewModel
    }

    override fun navigatePageListView() {
        fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.container, PageListFragment.newInstance())
                ?.addToBackStack(null)
                ?.commit()
    }
}
