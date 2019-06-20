package com.benboonya.pokemoninfo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.benboonya.pokemoninfo.berries.ui.list.BerryListFragment
import com.benboonya.pokemoninfo.pokemon.ui.list.PokemonListFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val pokemonListFragment: PokemonListFragment by lazy { PokemonListFragment.newInstance() }

    private val berryListFragment: BerryListFragment by lazy { BerryListFragment.newInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        supportFragmentManager.beginTransaction().replace(R.id.container, PokemonListFragment.newInstance()).commit()
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pokemonListFragment -> pokemonListFragment
            R.id.berryListFragment -> berryListFragment
            else -> null
        }?.let {
            supportFragmentManager.beginTransaction().replace(R.id.container, it).commit()
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        return true
    }
}
