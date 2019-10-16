package com.benboonya.pokemoninfo.berries.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.benboonya.pokemoninfo.common.util.ViewModelFactory
import com.benboonya.pokemoninfo.databinding.BerryDetailFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class BerryDetailFragment : DaggerFragment() {

    private lateinit var binding: BerryDetailFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<BerryDetailViewModel>
    private lateinit var viewModel: BerryDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(BerryDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BerryDetailFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel.apply {
            arguments?.let { assignArgument(BerryDetailFragmentArgs.fromBundle(it)) }
        }
        return binding.root
    }
}