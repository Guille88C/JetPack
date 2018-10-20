package com.sephoe.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.guill.coroutines.R
import com.sephoe.jetpack.ui.start.StartFragment

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            val finalHost = NavHostFragment.create(R.navigation.nav_graph)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, finalHost)
                    .setPrimaryNavigationFragment(finalHost)
                    .commitNow()
        }
    }
}
