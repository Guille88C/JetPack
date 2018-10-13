package com.sephoe.jetpack.ui.start

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.text.Editable
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch


class StartViewModel : ViewModel() {
    lateinit var view: StartView

    var name = ObservableField("William")
    var nameLiveData = MutableLiveData<String>()

    fun onChangeNameClick() {
        launch {
            delay(3000)
            name.set("Tito poe")
        }
    }

    fun onAfterTextChangedChangeName(p0: Editable?) {
        p0?.toString()?.let {
//            name.set(it)
            nameLiveData.value = it
        }
    }

    fun onPageListClick() {
        view.navigatePageListView()
    }
}
