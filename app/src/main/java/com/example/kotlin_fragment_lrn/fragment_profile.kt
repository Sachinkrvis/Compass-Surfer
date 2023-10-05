package com.example.kotlin_fragment_lrn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_fragment_lrn.databinding.ActivityFragmentProfileBinding

class fragment_profile:Fragment() {
    private lateinit var binding:ActivityFragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=ActivityFragmentProfileBinding.inflate(inflater,container,false)
        return binding.root
    }
}