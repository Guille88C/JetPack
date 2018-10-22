package com.sephoe.jetpack.elements.events

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class SingleLiveEventMultiObserver<T> : SingleLiveEvent<T>() {
    private val observers = mutableSetOf<Observer<in T>>()

    private val internalObserver = Observer<T> { t ->
        if (singleEventUtil.noObserved()) {
            observers.forEach { observer ->
                observer.onChanged(t)
            }
        }
    }

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        observers.add(observer)

        if (!hasObservers()) {
            parentObserve(owner, internalObserver)
        }
    }

    override fun removeObservers(owner: LifecycleOwner) {
        observers.clear()
        super.removeObservers(owner)
    }

    override fun removeObserver(observer: Observer<in T>) {
        observers.remove(observer)
        super.removeObserver(observer)
    }
}