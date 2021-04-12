package com.rezyfr.dicoding.bajp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rezyfr.dicoding.bajp.databinding.ActivityMainBinding
import com.rezyfr.dicoding.bajp.ui.main.ListViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            vpMain.adapter = ListViewPagerAdapter(supportFragmentManager)
            tablayoutMain.setupWithViewPager(vpMain)
        }
    }
}