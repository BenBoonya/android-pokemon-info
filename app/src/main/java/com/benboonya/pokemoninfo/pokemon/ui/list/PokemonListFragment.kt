package com.benboonya.pokemoninfo.pokemon.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.benboonya.pokemoninfo.R
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.ui.PagedItemListAdapter
import com.benboonya.pokemoninfo.common.util.ViewModelFactory
import com.benboonya.pokemoninfo.databinding.PokemonListFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PokemonListFragment : DaggerFragment() {

    lateinit var binding: PokemonListFragmentBinding

    private val navController: NavController by lazy { findNavController() }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<PokemonListViewModel>
    private lateinit var viewModel: PokemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(PokemonListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.adapter = PagedItemListAdapter(this::navigateToPokemonDetail)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        attachObserver()
    }

    private fun attachObserver() {
        with(viewModel) {
            isInitialLoading.observe(viewLifecycleOwner, Observer {
                binding.progressBar.isVisible = it
            })

            networkError.observe(viewLifecycleOwner, Observer {
                Toast.makeText(
                    context, it
                        ?: getString(R.string.message_generic_error), Toast.LENGTH_SHORT
                ).show()
            })

            pokemonList.observe(viewLifecycleOwner, Observer {
                binding.adapter?.submitList(it)
            })
        }
    }

    private fun navigateToPokemonDetail(item: GenericListItem) {
        val direction =
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailBottomSheet(item.url)
        navController.navigate(direction)
    }
}