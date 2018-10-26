package com.sephoe.domain.options

import com.sephoe.data.local.options.OptionsData
import org.junit.Assert
import org.junit.Test

class OptionsMapperTest {

    @Test
    fun toView() {
        val lEntity = arrayListOf(OptionsEntity("item 1"),
                OptionsEntity("item 2"))
        val lData = arrayListOf(OptionsData("item 1"),
                OptionsData("item 2"))
        Assert.assertEquals(lEntity, OptionsMapper.toView(lData))
    }
}