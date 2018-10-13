package com.sephoe.jetpack

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guill.coroutines.R
import com.sephoe.jetpack.ui.start.StartFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, StartFragment.newInstance())
                    .commitNow()
        }
    }
}
