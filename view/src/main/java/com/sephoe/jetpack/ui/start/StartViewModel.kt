package com.sephoe.jetpack.ui.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sephoe.domain.options.OptionsEntity
import com.sephoe.domain.options.OptionsUseCase
import com.sephoe.domain.options.OptionsUseCaseImpl
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

    fun init() {
        launch {
            val options = _optionsDomain.getOptions()

            for (item in options) {
                item.itemListener = {
                    clickLiveEvent.call()
                }
            }

            launch(UI) {
                optionsLiveData.value = options
            }
        }
    }

}
