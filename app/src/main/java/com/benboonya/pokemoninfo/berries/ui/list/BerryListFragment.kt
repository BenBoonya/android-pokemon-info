package com.benboonya.pokemoninfo.berries.ui.list

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
import com.benboonya.pokemoninfo.databinding.BerryListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BerryListFragment : Fragment() {

    lateinit var binding: BerryListFragmentBinding

    private val viewModel: BerryListViewModel by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BerryListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.adapter = PagedItemListAdapter(this::navigateToBerryDetail)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestBerryData()

    }

    private fun requestBerryData() {
        lifecycleScope.launch {
            viewModel.berryListResult.collectLatest {
                binding.adapter?.submitData(it)
            }
        }
    }

    private fun navigateToBerryDetail(item: GenericListItem) {
        val direction =
            BerryListFragmentDirections.actionBerryListFragmentToBerryDetailFragment(item.url)
        navController.navigate(direction)
    }
}