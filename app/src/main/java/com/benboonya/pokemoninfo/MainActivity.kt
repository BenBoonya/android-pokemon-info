package com.benboonya.pokemoninfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.benboonya.pokemoninfo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val navController: NavController by lazy {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainHostFragment) as NavHostFragment
        navHostFragment.navController
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpToolbar(binding.toolbar)
        binding.navView.setupWithNavController(navController)
    }

    private fun setUpToolbar(toolbar: Toolbar) {
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.pokemonListFragment, R.id.berryListFragment),
            binding.drawerLayout
        )
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}