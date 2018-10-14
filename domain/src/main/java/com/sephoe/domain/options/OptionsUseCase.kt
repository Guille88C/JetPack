package com.sephoe.domain.options

interface OptionsUseCase {
    fun getOptions(): List<OptionsEntity>
}