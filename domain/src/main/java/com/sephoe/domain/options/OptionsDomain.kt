package com.sephoe.domain.options

import com.sephoe.data.local.options.OptionsService

class OptionsDomain {
    private val service = OptionsService()

    private val options: List<OptionsEntity>
    get() {
        val options = service.options
        return OptionsMapper.fromService(options)
    }
}