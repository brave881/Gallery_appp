package com.example.gallery1.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery1.databinding.ItemTabLayoutBinding

class AdapterTab() : RecyclerView.Adapter<AdapterTab.VH>() {
    private var listener: ((String) -> Unit)? = null
    private lateinit var data: ArrayList<String>

    inner class VH(private val binding: ItemTabLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(s: String) {
            binding.tvTab.text = s
            binding.tvTab.setOnClickListener {
                listener?.invoke(data[adapterPosition])
            }
        }
    }

    fun submitItem(s: String) {

    }

    fun setOnClickListener(l: (String) -> Unit) {
        listener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val binding =
            ItemTabLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size
}