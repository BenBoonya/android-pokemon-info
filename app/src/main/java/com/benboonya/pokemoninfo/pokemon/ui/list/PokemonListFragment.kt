package com.benboonya.pokemoninfo.pokemon.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benboonya.pokemoninfo.databinding.PokemonListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    lateinit var binding: PokemonListFragmentBinding

    val viewModel: PokemonListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}