package com.albertomagalhaes.doggos.feature.favoriteBreedList

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.albertomagalhaes.doggos.commons.BaseFragment
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.databinding.FragmentFavoriteBreedListBinding
import com.albertomagalhaes.doggos.domain.navigation.navigateToDetails
import com.albertomagalhaes.doggos.feature.breedList.BreedListAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteBreedListFragment : BaseFragment<FragmentFavoriteBreedListBinding>() {

    private val viewModel: FavoriteBreedListViewModel by viewModel()
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
            viewModel.favoriteBreedListFlow.collect {
                if(it.isEmpty()) {
                    binding.rvBreedList.isVisible = false
                    binding.tvEmptyState.isVisible = true
                } else {
                    binding.rvBreedList.isVisible = true
                    binding.tvEmptyState.isVisible = false
                    breedListAdapter?.submitList(it)
                }

            }
        }
    }

    private fun favoriteBreed(breed: BreedModel) {
        viewModel.favoriteBreed(breed.copy(isFavorite = breed.isFavorite.not()))
    }

}