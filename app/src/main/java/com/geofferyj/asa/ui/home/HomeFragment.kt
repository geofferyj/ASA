package com.geofferyj.asa.ui.home

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.geofferyj.asa.R
import com.geofferyj.asa.databinding.FragmentHomeBinding
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.IValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.utils.EntryXComparator
import java.util.*


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val chartData2 = mutableListOf<Entry>()
        chartData2.add(Entry(0F, 2F))
        chartData2.add(Entry(1F, 2F))
        chartData2.add(Entry(2F, 4F))
        chartData2.add(Entry(3F, 3F))
        chartData2.add(Entry(4F, 8F))
        chartData2.add(Entry(5F, 1F))
        chartData2.add(Entry(6F, 9F))

        Collections.sort(chartData2, EntryXComparator())
        Log.d("MMMMM", "${chartData2.size}")



        val xAxis = mutableListOf<String>()
        xAxis.add("Mon")
        xAxis.add("Tue")
        xAxis.add("Wed")
        xAxis.add("Thur")
        xAxis.add("Fri")
        xAxis.add("Sat")
        xAxis.add("Sun")


        val lineDataSet = LineDataSet(chartData2,"tue")

        lineDataSet.valueFormatter = object : ValueFormatter(){
            override fun getFormattedValue(value: Float): String {
                return ""
            }
        }



        val valueFormatter = object : ValueFormatter(){
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                Log.d("MMMMM", "${axis?.mEntries?.size}")

                return xAxis[value.toInt()]
            }


        }

        val valueFormatter2 = object : ValueFormatter(){
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return ""
            }
        }

        binding.rvClasses.adapter = RvAdapter()
        binding.lineChart.data = LineData(lineDataSet)
        binding.lineChart.invalidate()
        binding.lineChart.apply {
            description.isEnabled = false
            axisLeft.isEnabled = false
            axisRight.isEnabled = false
            getXAxis().setAvoidFirstLastClipping(true);
            getXAxis().setDrawGridLines(true)
            getXAxis().granularity = 1f
            getXAxis().valueFormatter = valueFormatter

            legend.isEnabled = false
            getXAxis().position = XAxis.XAxisPosition.BOTTOM




        }

    }


}