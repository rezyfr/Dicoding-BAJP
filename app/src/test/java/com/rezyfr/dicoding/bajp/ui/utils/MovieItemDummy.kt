package com.rezyfr.dicoding.bajp.ui.utils

import com.rezyfr.dicoding.bajp.data.source.local.entity.MovieEntity

object MovieItemDummy {
    fun getMovieListResponse(): ArrayList<MovieEntity> {
        return arrayListOf(
                MovieEntity(
                    399566,
                    "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                    "Godzilla vs. Kong",
                    "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                    "2021-03-24",
                ), MovieEntity(
                    791373,
                    "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                    "Zack Snyder's Justice League",
                    "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                    "2021-03-18",
                ),
                MovieEntity(
                    412656,
                    "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                    "Chaos Walking",
                    "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                    "2021-02-24",
                )
            )

    }

    fun getMovieDetail(): MovieEntity {
        return MovieEntity(
            791373,
            "Zack Snyder's Justice League",
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
            "2021-03-18",
        )
    }
}