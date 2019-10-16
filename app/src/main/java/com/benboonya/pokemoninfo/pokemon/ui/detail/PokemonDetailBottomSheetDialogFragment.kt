package com.benboonya.pokemoninfo.pokemon.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.benboonya.pokemoninfo.common.ui.RoundedBottomSheetDialogFragment
import com.benboonya.pokemoninfo.common.util.ViewModelFactory
import com.benboonya.pokemoninfo.databinding.PokemonDetailBottomSheetFragmentBinding
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject


class PokemonDetailBottomSheetDialogFragment : DaggerAppCompatDialogFragment() {

    private lateinit var binding: PokemonDetailBottomSheetFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<PokemonDetailViewModel>
    private lateinit var viewModel: PokemonDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(PokemonDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonDetailBottomSheetFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel.apply {
            arguments?.let { assignArgument(PokemonDetailBottomSheetDialogFragmentArgs.fromBundle(it)) }
        }
        return binding.root
    }
}