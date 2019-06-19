package com.benboonya.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.benboonya.pokemoninfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy { Navigation.findNavController(this, R.id.mainHostFragment) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpToolbar(binding.toolbar)
        binding.navView.setupWithNavController(navController)
    }

    private fun setUpToolbar(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.pokemonListFragment, R.id.berryListFragment), binding.drawerLayout)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
