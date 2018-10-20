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
import kotlinx.android.synthetic.main.start_fragment.*

class StartFragment : androidx.fragment.app.Fragment() {

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

        viewModel.optionsLiveData.observe(this, Observer {
            it?.run {
                (rvStartOptions.adapter as? StartOptionsAdapter?)?.update(this)
            }
        })

        initOptions()

        viewModel.clickLiveEvent.observe(this, Observer {
            NavHostFragment.findNavController(this).navigate(R.id.action_startFragment_to_pageListFragment)
        })

        viewModel.onCreate(savedInstanceState)
    }

    private fun initOptions() {
        rvStartOptions.setHasFixedSize(true)
        rvStartOptions.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(context)
        rvStartOptions.adapter = StartOptionsAdapter()
    }
}
