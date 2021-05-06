package com.geofferyj.asa.ui.assignments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geofferyj.asa.R
import com.geofferyj.asa.databinding.FragmentAssignmentsBinding


class AssignmentsFragment : Fragment() {
   private  lateinit var binding: FragmentAssignmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssignmentsBinding.inflate(inflater, container, false)
        return binding.root
    }

}