package com.albertomagalhaes.doggos.feature.breedDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.albertomagalhaes.doggos.commons.AppActivity
import com.albertomagalhaes.doggos.databinding.FragmentBreedDetailsBinding

class BreedDetailsFragment : Fragment() {

    private lateinit var binding: FragmentBreedDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBreedDetailsBinding.inflate(inflater, container, false)
        (activity as AppActivity).setBottomNavigationVisibility(false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}