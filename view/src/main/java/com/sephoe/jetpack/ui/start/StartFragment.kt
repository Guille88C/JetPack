package com.sephoe.jetpack.ui.start

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.example.guill.coroutines.R
import com.example.guill.coroutines.databinding.StartFragmentBinding
import com.sephoe.jetpack.ui.adapter.StartOptionsAdapter
import com.sephoe.jetpack.ui.pagelist.PageListFragmentDirections
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : androidx.fragment.app.Fragment() {

    // Attributes

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding

    //----------------------------------------------------------------------------------------------
    // Fragment

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
        initObservers()

        viewModel.onCreate()
    }

    private fun initOptions() {
        rvStartOptions.setHasFixedSize(true)
        rvStartOptions.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        rvStartOptions.adapter = StartOptionsAdapter()
    }

    private fun initObservers() {
        viewModel.optionsLiveData.observe(this, Observer {
            it?.run {
                (rvStartOptions.adapter as? StartOptionsAdapter?)?.update(this)
            }
        })

        viewModel.clickLiveEvent.observe(this, Observer {
            val action = StartFragmentDirections.actionStartFragmentToPageListFragment()
            action.setAmount(10)
            NavHostFragment.findNavController(this).navigate(action)

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
    }

}
