package com.sephoe.jetpack.ui.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.sephoe.domain.options.OptionsUseCaseImpl
import com.sephoe.domain.options.OptionsEntity
import com.sephoe.domain.options.OptionsUseCase
import com.sephoe.jetpack.elements.events.SingleLiveEvent
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch


class StartViewModel : ViewModel() {

    // Attributes
    private val _optionsDomain: OptionsUseCase = OptionsUseCaseImpl()

    val optionsLiveData = MutableLiveData<List<OptionsEntity>>()
    val clickLiveEvent = SingleLiveEvent<Any?>()


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

    fun onGoToClick() {
        clickLiveEvent.call()
    }

}
