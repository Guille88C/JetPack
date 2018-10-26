package com.sephoe.data.local.options

import org.junit.Assert
import org.junit.Test

class OptionsRepositoryTest {
    @Test
    fun getOptions() {
        val lData = arrayListOf(OptionsData("Example 1"),
                OptionsData("Example 2"))
        val optionsRepository: OptionsRepository = OptionsRepositoryImpl()
        Assert.assertEquals(
                lData,
                optionsRepository.getOptions())
    }
}