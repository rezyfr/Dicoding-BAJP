package com.rezyfr.dicoding.bajp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity
import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity
import com.rezyfr.dicoding.bajp.databinding.ActivityDetailBinding
import com.rezyfr.dicoding.bajp.utils.Constant
import com.rezyfr.dicoding.bajp.utils.hideLoadingDialog
import com.rezyfr.dicoding.bajp.utils.showLoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val vm by viewModels<DetailViewModel>()

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
                vm.getMovieById(itemId).observe(this, ::observeMovieDetail)
            } else {
                vm.getTvById(itemId).observe(this, ::observeTvDetail)
            }
        }
    }

    private fun observeMovieDetail(movie: MovieEntity) {
        binding.movie = movie
        hideLoadingDialog()
    }

    private fun observeTvDetail(tv: TvEntity) {
        binding.tv = tv
        hideLoadingDialog()
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