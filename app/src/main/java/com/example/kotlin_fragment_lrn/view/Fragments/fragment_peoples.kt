package com.example.kotlin_fragment_lrn.view.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlin_fragment_lrn.databinding.ActivityFragmentPeoplesBinding

class fragment_peoples : Fragment() {

    private lateinit var binding: ActivityFragmentPeoplesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = ActivityFragmentPeoplesBinding.inflate(inflater, container, false)
        return binding.root
    }
}