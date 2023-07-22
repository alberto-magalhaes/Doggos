package com.albertomagalhaes.doggos.commons.extensions

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * A generic view holder to be used with any adapter and avoids boilerplate related to repeated
 * ViewHolder implementations.
 */
open class BindingViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)