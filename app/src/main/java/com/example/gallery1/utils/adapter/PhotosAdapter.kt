package com.example.gallery1.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gallery1.databinding.ImageItemsBinding
import com.example.gallery1.model.ResultPhoto

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.MyHolder>() {
    private var list = ArrayList<ResultPhoto>()
    private var listener: ((ResultPhoto) -> Unit)? = null

    inner class MyHolder(private val binding: ImageItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(resultt: ResultPhoto) {
            Glide.with(itemView).load(resultt.urls.small_s3).into(binding.imager)

            itemView.setOnClickListener {
                listener?.invoke(list[adapterPosition])
            }
        }
    }

    fun setOytimClickListener(l: (ResultPhoto) -> Unit) {
        listener = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = ImageItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    fun submitItem(item: List<ResultPhoto>) {
        val util = DiffUtill(item, list)
        val diff = DiffUtil.calculateDiff(util)
        list.clear()
        list.addAll(item)
        diff.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) = holder.bind(list[position])


    override fun getItemCount(): Int = list.size
}

class DiffUtill(var new: List<ResultPhoto>, var old: List<ResultPhoto>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[oldItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[oldItemPosition]
    }

}