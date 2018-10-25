package com.sephoe.domain.options

data class OptionsEntity(
        val name: String
) {
    var itemListener: ((item: OptionsEntity) -> Unit)? = null

    fun itemClicked() {
        itemListener?.invoke(this)
    }
}