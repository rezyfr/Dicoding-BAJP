package com.rezyfr.dicoding.bajp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.databinding.ItemMainLayoutBinding

class ItemAdapter<T>(
    private val listener: ItemClickListener
) : PagedListAdapter<Any, ItemAdapter<T>.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Any>() {
            override fun areItemsTheSame(oldItem: Any, newItem: Any): Boolean {
                return if (oldItem is MovieEntity && newItem is MovieEntity) {
                    oldItem.id == newItem.id
                } else {
                    (oldItem as TvEntity).id == (newItem as TvEntity).id
                }
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Any, newItem: Any): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class ViewHolder(val binding: ItemMainLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindTv(tv: TvEntity) {
            binding.title = tv.tvTitle
            binding.desc = tv.tvDesc
            binding.date = tv.tvDate
            binding.image = tv.getPosterImage()
            binding.root.setOnClickListener { view ->
                listener.onTvClicked(view, tv)
            }
        }

        fun bindMovie(movie: MovieEntity) {
            binding.title = movie.itemTitle
            binding.desc = movie.itemDesc
            binding.date = movie.itemDate
            binding.image = movie.getPosterImage()
            binding.root.setOnClickListener { view ->
                listener.onMovieClicked(view, movie)
            }
        }

        inline fun <reified T> Any?.tryCast(): Boolean {
            return this is T
        }
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = getItem(position)
        holder.apply {
            if (item.tryCast<MovieEntity>()) bindMovie(item as MovieEntity)
            else bindTv(item as TvEntity)
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
        fun onTvClicked(view: View, data: TvEntity)
        fun onMovieClicked(view: View, data: MovieEntity)
    }
}