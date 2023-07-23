package com.albertomagalhaes.doggos.feature.breedList

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.albertomagalhaes.doggos.commons.BaseFragment
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.databinding.FragmentBreedListBinding
import com.albertomagalhaes.doggos.domain.navigation.navigateToDetails
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedListFragment : BaseFragment<FragmentBreedListBinding>() {

    private val viewModel: BreedListViewModel by viewModel()
    private var breedListAdapter: BreedListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListAdapter()
    }

    private fun setupListAdapter() {
        breedListAdapter = BreedListAdapter(::favoriteBreed, findNavController()::navigateToDetails)
        binding.rvBreedList.adapter = breedListAdapter
        observeListUpdate()
    }

    private fun observeListUpdate() {
        lifecycleScope.launch {
            viewModel.breedListFlow.collect {
                breedListAdapter?.submitList(it)
            }
        }
    }

    private fun favoriteBreed(breed: BreedModel) {
        viewModel.favoriteBreed(breed.copy(isFavorite = breed.isFavorite.not()))
    }

}