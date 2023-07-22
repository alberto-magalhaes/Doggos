package com.albertomagalhaes.doggos.commons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

open class BaseFragment<Binding>(
    var bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> Binding
): Fragment() {

    private var binding: Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindingInflater.invoke(inflater, container, false)
        (activity as AppActivity).setBottomNavigationVisibility(true)
        return (binding as View).rootView
    }

}