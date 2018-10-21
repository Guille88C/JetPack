package com.sephoe.jetpack.ui.pagelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guill.coroutines.R
import kotlinx.android.synthetic.main.page_list_fragment.*

class PageListFragment : androidx.fragment.app.Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val amount = PageListFragmentArgs.fromBundle(arguments).amount
        tvPageListAmount.text = "amout = $amount"
    }

}