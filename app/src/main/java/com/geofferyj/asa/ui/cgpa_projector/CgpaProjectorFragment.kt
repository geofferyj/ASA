package com.geofferyj.asa.ui.cgpa_projector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geofferyj.asa.R
import com.geofferyj.asa.databinding.FragmentCgpaProjectorBinding

class CgpaProjectorFragment : Fragment() {
   private lateinit var binding: FragmentCgpaProjectorBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCgpaProjectorBinding.inflate(inflater, container, false)
        return binding.root
    }

}