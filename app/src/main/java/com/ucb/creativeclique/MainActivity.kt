package com.ucb.creativeclique

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.View


class MainActivity : AppCompatActivity() {
        private lateinit var fragmentContainer: FrameLayout
        private lateinit var bottomNavigationView: BottomNavigationView
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            fragmentContainer = findViewById(R.id.fragment_container)
            bottomNavigationView = findViewById(R.id.bottom_navigation)

            bottomNavigationView.setOnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_feed -> {
                        replaceFragment(FragmentFeed())
                        true
                    }

                    R.id.nav_notifications -> {
                        replaceFragment(FragmentNotification())
                        true
                    }

                    R.id.nav_post -> {
                        replaceFragment(FragmentPost())
                        true
                    }
                    R.id.nav_messages -> {
                        replaceFragment(FragmentMessage())
                        true
                    }

                    R.id.nav_profile -> {
                        replaceFragment(FragmentProfile())
                        true
                    }

                    else -> false
                }
            }


            replaceFragment(FragmentFeed())
        }
    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        when (fragment) {
            is FragmentPrivateMessage, is FragmentMenu -> {
                (fragment as? BackPressHandler)?.handleBackPressed() ?: super.onBackPressed()
            }
            is FragmentFeed -> {
                super.onBackPressed() // Default behavior (exit app)
            }
            else -> {
                showBottomNavigationBar()
                replaceFragment(FragmentFeed())
            }
        }
    }



    fun replaceFragment(fragment: Fragment) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
             bottomNavigationView.visibility = if (fragment is FragmentPrivateMessage) {
                 View.GONE
             } else {
                 View.VISIBLE
             }
         }

        fun navigateToHomeFragment() {
            replaceFragment(FragmentFeed())
        }
    fun hideBottomNavigationBar() {
        bottomNavigationView.visibility = View.GONE
    }
    fun showBottomNavigationBar() {
        bottomNavigationView.visibility = View.VISIBLE
    }
    // BackPressHandler.kt

    interface BackPressHandler {
        fun handleBackPressed()
    }


}