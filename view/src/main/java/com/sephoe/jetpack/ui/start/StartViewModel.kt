package com.sephoe.jetpack.ui.start

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.os.Bundle
import com.sephoe.domain.options.OptionsUseCaseImpl
import com.sephoe.domain.options.OptionsEntity
import com.sephoe.domain.options.OptionsUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


class StartViewModel : ViewModel() {

    // Attributes
    private val _optionsDomain: OptionsUseCase = OptionsUseCaseImpl()

    val optionsLiveData = MutableLiveData<List<OptionsEntity>>()


    //----------------------------------------------------------------------------------------------
    // ViewModel functions

    fun onCreate(savedInstanceState: Bundle?) {
        launch {
            val options = _optionsDomain.getOptions()
            launch(UI) {
                optionsLiveData.value = options
            }
        }
    }

}
