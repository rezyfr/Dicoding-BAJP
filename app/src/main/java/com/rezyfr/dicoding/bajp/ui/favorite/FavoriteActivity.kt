package com.rezyfr.dicoding.bajp.ui.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.paging.PagedList
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.SortUtils
import com.rezyfr.dicoding.bajp.databinding.ActivityFavoriteBinding
import com.rezyfr.dicoding.bajp.ui.detail.DetailActivity
import com.rezyfr.dicoding.bajp.ui.main.ItemAdapter
import com.rezyfr.dicoding.bajp.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteActivity : AppCompatActivity(), ItemAdapter.ItemClickListener {
    private lateinit var binding: ActivityFavoriteBinding
    private val viewModel by viewModels<FavoriteViewModel>()
    private var sort = ""
    private var key = ""

    private val movieAdapter = ItemAdapter<MovieEntity>(this)
    private val tvAdapter = ItemAdapter<TvEntity>(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            key = intent.getStringExtra(Constant.FRAGMENT_KEY).toString()
            key.let {
                toolbar.title = "Favorite $key"
                if (key == Constant.KEY_MOVIE) {
                    viewModel.getFavoriteMovies(sort)
                        .observe(this@FavoriteActivity, ::observeFavoriteMovies)
                    rvList.adapter = movieAdapter
                    cgFilter.setOnCheckedChangeListener { group, checkedId ->
                        sort = when (checkedId) {
                            chipAsc.id -> SortUtils.ASCENDING
                            chipDesc.id -> SortUtils.DESCENDING
                            chipNew.id -> SortUtils.NEWEST
                            chipOld.id -> SortUtils.OLDEST
                            else -> SortUtils.DEFAULT
                        }
                        viewModel.getFavoriteMovies(sort).observe(this@FavoriteActivity, ::observeFavoriteMovies)
                    }
                } else {
                    viewModel.getFavoriteTv(sort)
                        .observe(this@FavoriteActivity, ::observeFavoriteTv)
                    rvList.adapter = tvAdapter
                    cgFilter.setOnCheckedChangeListener { group, checkedId ->
                        sort = when (checkedId) {
                            chipAsc.id -> SortUtils.ASCENDING
                            chipDesc.id -> SortUtils.DESCENDING
                            chipNew.id -> SortUtils.NEWEST
                            chipOld.id -> SortUtils.OLDEST
                            else -> SortUtils.DEFAULT
                        }
                        viewModel.getFavoriteTv(sort)
                            .observe(this@FavoriteActivity, ::observeFavoriteTv)
                    }
                }
            }
        }
    }

    private fun observeFavoriteTv(tvList: PagedList<TvEntity>?) {
        tvAdapter.submitList(tvList as PagedList<Any>)
    }

    private fun observeFavoriteMovies(movieList: PagedList<MovieEntity>?) {
        movieAdapter.submitList(movieList as PagedList<Any>)
    }

    override fun onTvClicked(view: View, data: TvEntity) {
        val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
        intent.putExtra(Constant.FRAGMENT_KEY, key)
        intent.putExtra(Constant.ITEM_ID, data.id)
        startActivity(intent)
    }

    override fun onMovieClicked(view: View, data: MovieEntity) {
        val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
        intent.putExtra(Constant.FRAGMENT_KEY, key)
        intent.putExtra(Constant.ITEM_ID, data.id)
        startActivity(intent)
    }
}