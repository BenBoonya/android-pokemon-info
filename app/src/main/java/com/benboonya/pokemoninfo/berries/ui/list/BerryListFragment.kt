package com.benboonya.pokemoninfo.berries.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.benboonya.pokemoninfo.R
import com.benboonya.pokemoninfo.common.ui.PagedItemListAdapter
import com.benboonya.pokemoninfo.databinding.BerryListFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BerryListFragment : Fragment() {

    lateinit var binding: BerryListFragmentBinding

    private val viewModel: BerryListViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BerryListFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.adapter = PagedItemListAdapter {

        }
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
                android.widget.Toast.makeText(context, it
                        ?: getString(R.string.message_generic_error), android.widget.Toast.LENGTH_SHORT).show()

            })

            berryList.observe(viewLifecycleOwner, Observer {
                binding.adapter?.submitList(it)
            })
        }
    }
}