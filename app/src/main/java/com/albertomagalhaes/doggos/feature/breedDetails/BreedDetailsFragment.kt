package com.albertomagalhaes.doggos.feature.breedDetails

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import coil.load
import com.albertomagalhaes.doggos.R
import com.albertomagalhaes.doggos.commons.BaseFragment
import com.albertomagalhaes.doggos.commons.extensions.SingleTypeGenericAdapter
import com.albertomagalhaes.doggos.databinding.FragmentBreedDetailsBinding
import com.albertomagalhaes.doggos.databinding.ItemBreedImageListBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class BreedDetailsFragment : BaseFragment<FragmentBreedDetailsBinding>(false) {

    private val viewModel: BreedDetailsViewModel by viewModel()
    private val args: BreedDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBreed(args.breedId)
        observeUpdate()
    }

    private fun observeUpdate() {
        lifecycleScope.launch {
            viewModel.breedFlow.collect { breed ->
                val pictures = breed?.picturesURL.orEmpty()
                if(breed != null) {
                    appActivity.setToolbarTitle(getString(R.string.breed_gallery, breed.name))
                    appActivity.setToolbarNavigationButton(true)
                }
                if(pictures.isNotEmpty()) {
                    setupGrid(pictures)
                }
            }
        }
    }

    private fun setupGrid(picturesURLs: List<String>) {
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        layoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.rvBreedImages.layoutManager = layoutManager

        binding.rvBreedImages.adapter = SingleTypeGenericAdapter(
            ItemBreedImageListBinding::inflate,
            picturesURLs
        ) { item, binding, _, _ ->
            binding.apply {
                cover.load(item)
            }
        }
    }

}