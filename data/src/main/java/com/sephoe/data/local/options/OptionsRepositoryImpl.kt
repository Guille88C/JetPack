package com.sephoe.data.local.options

class OptionsRepositoryImpl : OptionsRepository {
    override fun getOptions(): List<OptionsData> {
        return arrayListOf(
                OptionsData("Example 1"),
                OptionsData("Example 2")
        )
    }
}