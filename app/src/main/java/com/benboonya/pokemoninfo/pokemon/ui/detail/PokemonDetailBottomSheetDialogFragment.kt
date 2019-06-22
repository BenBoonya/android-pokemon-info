package com.benboonya.pokemoninfo.pokemon.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.benboonya.pokemoninfo.common.ui.RoundedBottomSheetDialogFragment
import com.benboonya.pokemoninfo.databinding.PokemonDetailBottomSheetFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class PokemonDetailBottomSheetDialogFragment : RoundedBottomSheetDialogFragment() {

    private lateinit var binding: PokemonDetailBottomSheetFragmentBinding

    private val viewModel: PokemonDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = PokemonDetailBottomSheetFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel.apply {
            arguments?.let { assignArgument(PokemonDetailBottomSheetDialogFragmentArgs.fromBundle(it)) }
        }
        return binding.root
    }
}