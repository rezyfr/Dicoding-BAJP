package com.rezyfr.dicoding.bajp.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.rezyfr.dicoding.bajp.utils.Constant

class ListViewPagerAdapter(
    fm: FragmentManager
) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = listOf(
        ListFragment.newInstance(Constant.KEY_MOVIE),
        ListFragment.newInstance(Constant.KEY_TV)
    )

    override fun getItem(position: Int): Fragment = pages[position]

    override fun getPageTitle(position: Int): CharSequence = when (position) {
        0 -> "Movie"
        else -> "Tv Show"
    }

    override fun getCount(): Int = pages.size
}
