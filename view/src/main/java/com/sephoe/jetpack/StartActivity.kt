package com.sephoe.jetpack

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.guill.coroutines.R

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            val finalHost = NavHostFragment.create(R.navigation.nav_graph)
            supportFragmentManager.beginTransaction()
                    .replace(android.R.id.content, finalHost)
                    .setPrimaryNavigationFragment(finalHost)
                    .commitNow()
        }
    }
}
