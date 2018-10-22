package com.sephoe.jetpack.elements.events

import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEventUtil {
    private val pending = AtomicBoolean(false)

    fun noObserved() = pending.compareAndSet(true, false)

    fun reset() {
        pending.set(true)
    }
}