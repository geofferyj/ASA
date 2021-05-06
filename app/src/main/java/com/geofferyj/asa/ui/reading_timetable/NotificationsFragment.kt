package com.geofferyj.asa.ui.reading_timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geofferyj.asa.databinding.FragmentReadingTimetableBinding

class NotificationsFragment : Fragment() {

    private lateinit var binding: FragmentReadingTimetableBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentReadingTimetableBinding.inflate(inflater, container, false)

        return binding.root
    }

}