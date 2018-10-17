package com.sephoe.domain.options

import com.sephoe.data.local.options.OptionsRepository
import com.sephoe.data.local.options.OptionsRepositoryImpl

class OptionsUseCaseImpl : OptionsUseCase {
    private val _service: OptionsRepository = OptionsRepositoryImpl()

    override fun getOptions(): List<OptionsEntity> {
        val options = _service.getOptions()
        return OptionsMapper.toView(options)
    }
}