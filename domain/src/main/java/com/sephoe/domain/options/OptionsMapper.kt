package com.sephoe.domain.options

import com.sephoe.data.local.options.OptionsData
import java.util.*

object OptionsMapper {
    fun fromService(data: List<OptionsData>): List<OptionsEntity> {
        val result = ArrayList<OptionsEntity>()
        for(it in data) {
            result.add(OptionsEntity(it.name))
        }
        return result
    }

    fun toService(data: List<OptionsEntity>): List<OptionsData> {
        val result = ArrayList<OptionsData>()
        for(it in data) {
            result.add(OptionsData(it.name))
        }
        return result
    }
}