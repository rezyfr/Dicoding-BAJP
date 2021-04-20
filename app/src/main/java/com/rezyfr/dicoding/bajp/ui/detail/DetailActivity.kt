package com.rezyfr.dicoding.bajp.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.dicoding.academies.moviecataloguedatamanagement.vo.Status
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.data.source.utils.Resource
import com.rezyfr.dicoding.bajp.databinding.ActivityDetailBinding
import com.rezyfr.dicoding.bajp.utils.Constant
import com.rezyfr.dicoding.bajp.utils.hideLoadingDialog
import com.rezyfr.dicoding.bajp.utils.showLoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val vm by viewModels<DetailViewModel>()
    private var isEntityFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val key = intent.getStringExtra(Constant.FRAGMENT_KEY)
        val itemId = intent.getIntExtra(Constant.ITEM_ID, 0)
        key?.let {
            showLoadingDialog()
            if (key == Constant.KEY_MOVIE) {
                vm.detailMovie.observe(this, ::observeMovieDetail)
                binding.fabFavorite.setOnClickListener {
                    vm.setMovieFavorite()
                    setFavoriteState(!isEntityFavorite)
                }
            } else {
                vm.detailTv.observe(this, ::observeTvDetail)
                binding.fabFavorite.setOnClickListener {
                    vm.setTvFavorite()
                    setFavoriteState(!isEntityFavorite)
                }
            }
        }
        vm.setSelectedItem(itemId)
    }

    private fun observeMovieDetail(movie: Resource<MovieEntity>) {
        when (movie.status) {
            Status.LOADING -> showLoadingDialog(true)
            Status.SUCCESS -> {
                binding.movie = movie.data
                hideLoadingDialog()
                setFavoriteState(movie.data?.isFavorite ?: false)
            }
            Status.ERROR -> {
                hideLoadingDialog()
                Toast.makeText(this, "${movie.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun observeTvDetail(tv: Resource<TvEntity>) {
        when (tv.status) {
            Status.LOADING -> showLoadingDialog(true)
            Status.SUCCESS -> {
                binding.tv = tv.data
                setFavoriteState(tv.data?.isFavorite ?: false)
                hideLoadingDialog()
            }
            Status.ERROR -> {
                hideLoadingDialog()
                Toast.makeText(this, "${tv.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun setFavoriteState(isFavorite: Boolean) {
        isEntityFavorite = isFavorite
        if (isFavorite) binding.fabFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_fav_filled
            )
        ) else binding.fabFavorite.setImageDrawable(
            ContextCompat.getDrawable(
                this,
                R.drawable.ic_fav_outlined
            )
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        hideLoadingDialog()
    }
}