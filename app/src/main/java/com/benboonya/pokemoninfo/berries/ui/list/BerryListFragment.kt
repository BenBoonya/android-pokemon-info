package com.benboonya.pokemoninfo.berries.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.benboonya.pokemoninfo.R
import com.benboonya.pokemoninfo.common.model.GenericListItem
import com.benboonya.pokemoninfo.common.ui.PagedItemListAdapter
import com.benboonya.pokemoninfo.common.util.ViewModelFactory
import com.benboonya.pokemoninfo.databinding.BerryListFragmentBinding
import dagger.android.support.DaggerAppCompatDialogFragment
import javax.inject.Inject

class BerryListFragment : DaggerAppCompatDialogFragment() {

    lateinit var binding: BerryListFragmentBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<BerryListViewModel>
    private lateinit var viewModel: BerryListViewModel

    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(BerryListViewModel::class.java)
    }

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
                android.widget.Toast.makeText(
                    context,
                    it
                        ?: getString(R.string.message_generic_error),
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            })

            berryList.observe(viewLifecycleOwner, Observer {
                binding.adapter?.submitList(it)
            })
        }
    }

    private fun navigateToBerryDetail(item: GenericListItem) {
        val direction =
            BerryListFragmentDirections.actionBerryListFragmentToBerryDetailFragment(item.url)
        navController.navigate(direction)
    }
}