package com.rezyfr.dicoding.bajp.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.databinding.ItemMainLayoutBinding

class MovieItemAdapter(
    private val listener: ItemClickListener
) : RecyclerView.Adapter<MovieItemAdapter.ViewHolder>() {

    private val movieList = arrayListOf<MovieEntity>()

    fun updateData(list: List<MovieEntity>) {
        this.movieList.clear()
        this.movieList.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = movieList[position]
        holder.apply {
            binding.movie = item
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

    override fun getItemCount(): Int = movieList.size


    interface ItemClickListener {
        fun onItemClicked(view: View, data: MovieEntity)
    }
}