package com.albertomagalhaes.doggos.feature.favoriteBreedList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import com.albertomagalhaes.doggos.commons.AppActivity
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.databinding.FragmentFavoriteBreedListBinding
import com.albertomagalhaes.doggos.feature.breedList.BreedListAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteBreedListFragment : Fragment() {

    private var breedListAdapter: BreedListAdapter? = null
    private lateinit var binding: FragmentFavoriteBreedListBinding
    private val viewModel: FavoriteBreedListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBreedListBinding.inflate(inflater, container, false)
        (activity as AppActivity).setBottomNavigationVisibility(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListAdapter()
    }

    private fun setupListAdapter() {
        breedListAdapter = BreedListAdapter(::favoriteBreed, ::navigateToDetails)
        binding.rvBreedList.adapter = breedListAdapter
        observeListUpdate()
    }

    private fun observeListUpdate() {
        lifecycleScope.launch {
            viewModel.favoriteBreedListFlow.collect {
                breedListAdapter?.submitList(it)
            }
        }
    }

    private fun favoriteBreed(breed: BreedModel) {
        viewModel.favoriteBreed(breed.copy(isFavorite = breed.isFavorite.not()))
    }

    private fun navigateToDetails(breed: BreedModel? = null){
        val request = NavDeepLinkRequest.Builder.fromUri("android-app://com.albertomagalhaes.doggos.breed/${breed?.id}".toUri())
            .build()

        findNavController().navigate(request)
    }

}