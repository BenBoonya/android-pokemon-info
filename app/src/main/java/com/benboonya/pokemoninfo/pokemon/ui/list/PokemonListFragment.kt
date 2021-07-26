package com.benboonya.pokemoninfo.pokemon.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.ui.PagedItemListAdapter
import com.benboonya.pokemoninfo.databinding.PokemonListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PokemonListFragment : Fragment() {

    lateinit var binding: PokemonListFragmentBinding

    private val navController: NavController by lazy { findNavController() }

    val viewModel: PokemonListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.adapter = PagedItemListAdapter(this::navigateToPokemonDetail)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPokemonData()
    }

    private fun requestPokemonData() {
        lifecycleScope.launch {
            viewModel.pokemonListResult.collectLatest {
                binding.adapter?.submitData(it)
            }
        }
    }

    private fun navigateToPokemonDetail(item: GenericListItem) {
        val direction =
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailBottomSheet(item.url)
        navController.navigate(direction)
    }
}