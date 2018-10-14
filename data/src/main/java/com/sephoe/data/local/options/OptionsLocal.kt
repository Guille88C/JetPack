package com.sephoe.data.local.options

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

class OptionsLocal {
    val options: LiveData<List<OptionsModel>>
        get() {
            val ld = MutableLiveData<List<OptionsModel>>()
            ld.value =
                    arrayListOf(
                            OptionsModel("Example 1"),
                            OptionsModel("Example 2")
                    )
            return ld
        }
}