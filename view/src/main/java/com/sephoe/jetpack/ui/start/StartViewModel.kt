package com.sephoe.jetpack.ui.start

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.os.Bundle
import android.text.Editable
import com.sephoe.domain.options.OptionsDomain
import com.sephoe.domain.options.OptionsEntity
import com.sephoe.domain.options.OptionsMapper
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


class StartViewModel : ViewModel() {

    // Attributes
    private val _optionsDomain = OptionsDomain()

    val optionsLiveData = MutableLiveData<List<OptionsEntity>>()


    //----------------------------------------------------------------------------------------------
    // ViewModel functions

    fun onCreate(savedInstanceState: Bundle?) {
        launch {
            val options = _optionsDomain.options
            launch(UI) {
                optionsLiveData.value = options
            }
        }
    }

}
