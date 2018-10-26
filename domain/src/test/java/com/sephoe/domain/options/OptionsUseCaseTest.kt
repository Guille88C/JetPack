package com.sephoe.domain.options

import org.junit.Assert
import org.junit.Test

class OptionsUseCaseTest {
    @Test
    fun getOptions() {
        val lEntity = arrayListOf(OptionsEntity("Example 1"),
                OptionsEntity("Example 2"))
        val options: OptionsUseCase = OptionsUseCaseImpl()
        Assert.assertEquals(lEntity, options.getOptions())
    }
}