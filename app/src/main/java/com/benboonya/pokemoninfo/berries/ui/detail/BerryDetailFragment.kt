package com.benboonya.pokemoninfo.berries.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benboonya.pokemoninfo.databinding.BerryDetailFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BerryDetailFragment : Fragment() {

    private lateinit var binding: BerryDetailFragmentBinding

    private val viewModel: BerryDetailViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BerryDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel.apply {
            arguments?.let { assignArgument(BerryDetailFragmentArgs.fromBundle(it)) }
        }
        return binding.root
    }
}