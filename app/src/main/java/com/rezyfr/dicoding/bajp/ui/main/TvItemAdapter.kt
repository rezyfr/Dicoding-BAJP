package com.rezyfr.dicoding.bajp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.databinding.ItemMainLayoutBinding

class TvItemAdapter(
    private val listener: ItemClickListener
) : RecyclerView.Adapter<TvItemAdapter.ViewHolder>() {


    private val tvList = arrayListOf<TvEntity>()

    fun updateData(list: List<TvEntity>) {
        this.tvList.clear()
        this.tvList.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = tvList[position]
        holder.apply {
            binding.tv = item
            binding.root.setOnClickListener { view ->
                listener.onItemClicked(view, item)

            }
        }
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

    interface ItemClickListener {
        fun onItemClicked(view: View, data: TvEntity)
    }

    override fun getItemCount(): Int = tvList.size
}