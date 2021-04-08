package com.rezyfr.submission1.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.rezyfr.submission1.R
import com.rezyfr.submission1.databinding.ActivityDetailBinding
import com.rezyfr.submission1.utils.Constant

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
            vm.setSelectedItem(itemId)
            val item = vm.getItemById(it)
            binding.item = item
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}