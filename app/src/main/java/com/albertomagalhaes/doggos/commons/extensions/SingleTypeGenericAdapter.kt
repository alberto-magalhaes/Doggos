package com.albertomagalhaes.doggos.commons.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class SingleTypeGenericAdapter<Item, Binding : ViewBinding>(
    var bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> Binding,
    var list: List<Item>,
    var onBind: (item: Item, binding: Binding, Int, SingleTypeGenericAdapter<Item, Binding>) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            bindingInflater.invoke(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), this
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SingleTypeGenericAdapter<*, *>.ViewHolder).bindItem(position)
    }

    inner class ViewHolder(
        private val binding: Binding,
        private val genericAdapter: SingleTypeGenericAdapter<Item, Binding>
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(position: Int) {
            list[position].apply {
                onBind(this, binding, position, genericAdapter)
            }
        }
    }

}