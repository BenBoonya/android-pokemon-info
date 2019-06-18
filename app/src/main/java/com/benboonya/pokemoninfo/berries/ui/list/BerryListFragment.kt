package com.benboonya.pokemoninfo.berries.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benboonya.pokemoninfo.databinding.BerryListFragmentBinding

class BerryListFragment : Fragment() {

    lateinit var binding: BerryListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BerryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}