package com.sephoe.jetpack.elements.events

import android.util.Log
import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

open class SingleLiveEvent<T> : MutableLiveData<T>() {
    protected val singleEventUtil = SingleLiveEventUtil()

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        if (hasActiveObservers()) {
            Log.d("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.")
        }
        super.observe(owner, Observer<T> { t ->
            if (singleEventUtil.noObserved()) {
                observer.onChanged(t)
            }
        })
    }

    @MainThread
    override fun setValue(@Nullable t: T?) {
        singleEventUtil.reset()
        super.setValue(t)
    }

    /**
     * Used for cases where T is Void, to make calls cleaner.
     */
    @MainThread
    fun call() {
        value = null
    }

    protected fun parentObserve(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, observer)
    }
}