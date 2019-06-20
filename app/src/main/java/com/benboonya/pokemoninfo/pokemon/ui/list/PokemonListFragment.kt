package com.benboonya.pokemoninfo.pokemon.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.benboonya.pokemoninfo.R
import com.benboonya.pokemoninfo.common.ui.PagedItemListAdapter
import com.benboonya.pokemoninfo.databinding.PokemonListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PokemonListFragment : Fragment() {

    companion object {
        fun newInstance() = PokemonListFragment()
    }

    lateinit var binding: PokemonListFragmentBinding

    val viewModel: PokemonListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PokemonListFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.adapter = PagedItemListAdapter()
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
}