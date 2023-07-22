package com.albertomagalhaes.doggos.commons.extensions

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

/**
 * Diffs [Identifiable] to reuse [DiffUtil] boilerplate of checking id and the instance itself.
 * It is important that the instance of [Identifiable] be a data class to optmize the
 * [areContentsTheSame] method
 */
class IdDiffUtil<T : Identifiable<*>> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(
        oldItem: T,
        newItem: T
    ) = oldItem.id == newItem.id

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(
        oldItem: T,
        newItem: T
    ) = oldItem == newItem

    override fun getChangePayload(oldItem: T, newItem: T): Any {
        return true
    }
}