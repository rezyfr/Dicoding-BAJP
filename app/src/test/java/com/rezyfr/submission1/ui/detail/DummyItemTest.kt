package com.rezyfr.submission1.ui.detail

import com.rezyfr.submission1.R
import com.rezyfr.submission1.data.ItemEntity

object DummyItemTest {
    fun returnDummyItem(): ItemEntity = ItemEntity(
        1,
        "A Star is Born",
        "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
        R.drawable.poster_a_start_is_born,
        "October 5, 2018"
    )
}