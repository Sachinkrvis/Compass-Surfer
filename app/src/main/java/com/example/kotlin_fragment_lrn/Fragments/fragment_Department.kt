package com.example.kotlin_fragment_lrn.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_fragment_lrn.databinding.ActivityFragmentDepartmentBinding

class fragment_Department:Fragment() {
    private lateinit var binding:ActivityFragmentDepartmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=ActivityFragmentDepartmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}