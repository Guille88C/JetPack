package com.sephoe.data.local.options

class OptionsService {
    val options: List<OptionsData>
        get() {
            return arrayListOf(
                    OptionsData("Example 1"),
                    OptionsData("Example 2")
            )
        }
}