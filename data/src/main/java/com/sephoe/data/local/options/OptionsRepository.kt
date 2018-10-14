package com.sephoe.data.local.options

interface OptionsRepository {
    fun getOptions(): List<OptionsData>
}