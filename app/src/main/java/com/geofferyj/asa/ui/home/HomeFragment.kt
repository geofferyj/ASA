package com.geofferyj.asa.ui.home

import android.graphics.Color
import android.os.Bundle
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
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate


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

        val chartData1 = mutableListOf<Entry>()
        chartData1.add(Entry(1F, 2F))
        chartData1.add(Entry(2F, 4F))
        chartData1.add(Entry(3F, 6F))
        chartData1.add(Entry(4F, 8F))
        chartData1.add(Entry(5F, 10F))
        chartData1.add(Entry(6F, 12F))


        val chartData2 = mutableListOf<Entry>()
        chartData2.add(Entry(1F, 2F))
        chartData2.add(Entry(2F, 4F))
        chartData2.add(Entry(3F, 3F))
        chartData2.add(Entry(4F, 8F))
        chartData2.add(Entry(5F, 1F))
        chartData2.add(Entry(6F, 0F))


        val xAxis = mutableListOf<String>()
        xAxis.add("JAN")
        xAxis.add("FEB")
        xAxis.add("MAR")
        xAxis.add("APR")
        xAxis.add("MAY")
        xAxis.add("JUN")


        val lineDataSet1 = LineDataSet(chartData1,"mon")
        lineDataSet1.color = Color.RED
        lineDataSet1.valueFormatter = object : ValueFormatter(){
            override fun getFormattedValue(value: Float): String {
                return ""
            }
        }
        lineDataSet1.axisDependency = YAxis.AxisDependency.LEFT
        val lineDataSet2 = LineDataSet(chartData2,"tue")



        val valueFormatter = object : ValueFormatter(){
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return xAxis[value.toInt()]
            }
        }

        val valueFormatter2 = object : ValueFormatter(){
            override fun getAxisLabel(value: Float, axis: AxisBase?): String {
                return ""
            }
        }

        binding.rvClasses.adapter = RvAdapter()
        binding.lineChart.data = LineData(lineDataSet1, lineDataSet2)
        binding.lineChart.apply {
            description.isEnabled = false
            axisLeft.isEnabled = true
            axisLeft.setDrawZeroLine(true)
            axisRight.isEnabled = false
//            getXAxis().setAvoidFirstLastClipping(true);
            getXAxis().setDrawGridLines(false)
            getXAxis().valueFormatter = valueFormatter

            legend.isEnabled = false
            getXAxis().labelCount = 6



        }

    }


}