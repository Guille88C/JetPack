package com.sephoe.domain.options

import com.sephoe.data.local.options.OptionsService

class OptionsDomain {
    private val _service = OptionsService()

    val options: List<OptionsEntity>
    get() {
        val options = _service.options
        return OptionsMapper.fromService(options)
    }
}