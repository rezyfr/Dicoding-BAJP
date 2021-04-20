package com.rezyfr.dicoding.bajp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rezyfr.dicoding.bajp.R
import com.rezyfr.dicoding.bajp.databinding.ActivityMainBinding
import com.rezyfr.dicoding.bajp.ui.favorite.FavoriteActivity
import com.rezyfr.dicoding.bajp.ui.main.ListViewPagerAdapter
import com.rezyfr.dicoding.bajp.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            toolbarMain.apply {
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.menu_favorite -> {
                            val key = if(vpMain.currentItem == 0){
                                Constant.KEY_MOVIE
                            } else {
                                Constant.KEY_TV
                            }
                            val intent = Intent(this@MainActivity, FavoriteActivity::class.java).apply {
                                putExtra(Constant.FRAGMENT_KEY, key)
                            }
                            startActivity(intent)
                        }
                    }
                    false
                }
            }
            toolbarMain.title = resources.getString(R.string.app_name)
            vpMain.adapter = ListViewPagerAdapter(supportFragmentManager)
            tablayoutMain.setupWithViewPager(vpMain)
        }
    }
}