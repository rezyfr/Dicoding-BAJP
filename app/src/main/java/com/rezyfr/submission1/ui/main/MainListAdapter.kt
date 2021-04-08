package com.rezyfr.submission1.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.submission1.R
import com.rezyfr.submission1.data.ItemEntity
import com.rezyfr.submission1.databinding.ItemMainLayoutBinding

class MainListAdapter(
    private val listener: ItemClickListener
) : RecyclerView.Adapter<MainListAdapter.ViewHolder>() {

    private var dataList: List<ItemEntity> = listOf()

    fun updateData(list: List<ItemEntity>) {
        this.dataList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_main_layout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.apply {
            binding.item = data

            itemView.setOnClickListener {
                listener.onItemClicked(it, data)
            }
        }

    }

    override fun getItemCount(): Int = dataList.size

    inner class ViewHolder(val binding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    interface ItemClickListener {
        fun onItemClicked(view: View, data: ItemEntity)
    }
}