package com.geofferyj.asa.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geofferyj.asa.databinding.RvItemLayoutBinding

class RvAdapter: RecyclerView.Adapter<RvAdapter.VH>() {

    val items = listOf(1,1,1)
    inner class VH(binding: RvItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(i: Int) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemLayoutBinding.inflate(inflater, parent, false)

        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val i = items[position]
        holder.bind(i)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}