package com.albertomagalhaes.doggos.commons

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.albertomagalhaes.doggos.R
import com.albertomagalhaes.doggos.databinding.ActivityAppBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class AppActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAppBinding
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNav = binding.navView
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_app) as NavHostFragment
        navController = navHostFragment.navController
        bottomNav.setupWithNavController(navController)
        setSupportActionBar(binding.toolbar)
    }

    fun setBottomNavigationVisible(isVisible: Boolean) {
        bottomNav.visibility = if(isVisible) View.VISIBLE else View.GONE
    }

    fun setToolbarTitle(text: String) {
        binding.toolbar.title = text
    }

    fun setToolbarNavigationButton(visible: Boolean) {
        binding.toolbar.apply {
            navigationIcon =
                if(visible) AppCompatResources.getDrawable(this@AppActivity, R.drawable.ic_back)
                else null
            setNavigationOnClickListener { onBackPressed() }
        }
    }

}