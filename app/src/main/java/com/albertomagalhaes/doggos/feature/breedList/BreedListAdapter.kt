package com.albertomagalhaes.doggos.feature.breedList

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.albertomagalhaes.doggos.R
import com.albertomagalhaes.doggos.commons.extensions.BindingViewHolder
import com.albertomagalhaes.doggos.commons.extensions.IdDiffUtil
import com.albertomagalhaes.doggos.commons.extensions.viewBinding
import com.albertomagalhaes.doggos.data.internal.model.BreedModel
import com.albertomagalhaes.doggos.databinding.ItemBreedListBinding


class BreedListAdapter(
    private val onFavorite: (BreedModel) -> Unit,
    private val onBreedClick: (BreedModel) -> Unit
) : ListAdapter<BreedModel, BindingViewHolder<ItemBreedListBinding>>(IdDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<ItemBreedListBinding> {
        val binding = parent.viewBinding(ItemBreedListBinding::inflate)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<ItemBreedListBinding>, position: Int) {
        val breed = getItem(position)
        holder.binding.apply {
            tvBreedName.text = breed.name
            if(breed.isFavorite) {
                btnFavorite.setImageDrawable(ContextCompat.getDrawable(holder.binding.root.context, R.drawable.ic_star_full))
            } else {
                btnFavorite.setImageDrawable(ContextCompat.getDrawable(holder.binding.root.context, R.drawable.ic_star_empty))
            }

            btnFavorite.setOnClickListener {
                onFavorite(breed)
            }
            root.setOnClickListener {
                onBreedClick(breed)
            }
        }
    }

}