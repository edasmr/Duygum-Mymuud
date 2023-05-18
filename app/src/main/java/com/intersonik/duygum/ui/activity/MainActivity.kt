package com.intersonik.duygum.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.intersonik.duygum.R
import com.intersonik.duygum.data.preferences.MyPreferences
import com.intersonik.duygum.databinding.ActivityMainBinding
import com.intersonik.duygum.ui.viewmodel.SignInViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SignInViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("eda",viewModel.getToken().toString())
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.home_nav, R.id.profil_nav, R.id.sohbet_nav, R.id.ag_nav, R.id.psikolog_nav
            )
        )
        supportActionBar?.hide()
        //setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
    }
}