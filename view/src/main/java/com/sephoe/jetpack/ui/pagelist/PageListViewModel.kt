package com.sephoe.jetpack.ui.pagelist

import androidx.lifecycle.ViewModel
import com.sephoe.jetpack.elements.events.SingleLiveEventMultiObserver

class PageListViewModel : ViewModel() {

    // Attributes

    var amount: Int = 0
    val clickLiveEvent = SingleLiveEventMultiObserver<Any?>()

    //----------------------------------------------------------------------------------------------
    // ViewModel functions

    fun onGoToClick() {
        clickLiveEvent.call()
    }

}