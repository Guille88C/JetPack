package com.sephoe.jetpack.ui.pagelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.guill.coroutines.R

class PageListFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance(): PageListFragment = PageListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.page_list_fragment, container, false)
    }
}