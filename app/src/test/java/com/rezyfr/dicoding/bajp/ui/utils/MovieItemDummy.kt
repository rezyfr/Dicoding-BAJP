package com.rezyfr.dicoding.bajp.ui.utils

import com.rezyfr.dicoding.bajp.data.source.remote.response.*

object MovieItemDummy {
    fun getMovieListResponse(): MovieListResponse {
        return MovieListResponse(1, 500,
            listOf(
                MovieResponse(
                    "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                    "en",
                    "Godzilla vs. Kong",
                    false,
                    "Godzilla vs. Kong",
                    listOf(28, 878),
                    "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                    "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
                    "2021-03-24",
                    11504.314,
                    8.4,
                    399566,
                    false,
                    4115
                ), MovieResponse(
                    "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
                    "en",
                    "Zack Snyder's Justice League",
                    false,
                    "Zack Snyder's Justice League",
                    listOf(
                        28,
                        12,
                        14,
                        878
                    ),
                    "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
                    "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
                    "2021-03-18",
                    4456.627,
                    8.6,
                    791373,
                    false,
                    4747
                ),
                MovieResponse(
                    "Two unlikely companions embark on a perilous adventure through the badlands of an unexplored planet as they try to escape a dangerous and disorienting reality, where all inner thoughts are seen and heard by everyone.",
                    "en",
                    "Chaos Walking",
                    false,
                    "Chaos Walking",
                    listOf(
                        878,
                        28,
                        12,
                        53
                    ),
                    "/9kg73Mg8WJKlB9Y2SAJzeDKAnuB.jpg",
                    "/5NxjLfs7Bi07bfZCRl9CCnUw7AA.jpg",
                    "2021-02-24",
                    2919.395,
                    7.5,
                    412656,
                    false,
                    286
                )
            ), 10000
        )
    }
    fun getMovieDetail(): MovieDetailResponse {
        return MovieDetailResponse(
            "en",
            "tt12361974",
            false,
            "Zack Snyder's Justice League",
            "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
            0,
            listOf(
                GenresItem(
                    "Action", 28
                ),
                GenresItem(
                    "Adventure", 12
                ),
                GenresItem(
                    "Fantasy", 14
                ),
                GenresItem(
                    "Science Fiction", 878,
                ),
            ),
            4456.627,
            listOf(
                ProductionCountriesItem(
                    "US",
                    "United States of America"
                )
            ),
            791373,
            4767,
            70000000,
            "Determined to ensure Superman's ultimate sacrifice was not in vain, Bruce Wayne aligns forces with Diana Prince with plans to recruit a team of metahumans to protect the world from an approaching threat of catastrophic proportions.",
            "Zack Snyder's Justice League",
            242,
            "/tnAuB8q5vv7Ax9UAEje5Xi4BXik.jpg",
            listOf(
                SpokenLanguagesItem(
                    "English",
                    "en",
                    "English"
                )
            ),
            listOf(
                ProductionCompaniesItem(
                    "/ky0xOc5OrhzkZ1N6KyUxacfQsCk.png", "Warner Bros. Pictures", 174, "US"
                ), ProductionCompaniesItem(
                    null, "Warner Bros. Pictures", 114152, "US"
                ), ProductionCompaniesItem(
                    "/z7H707qUWigbjHnJDMfj6QITEpb.png", "Atlas Entertainment", 507, "US"
                ), ProductionCompaniesItem(
                    "/2Tc1P3Ac8M479naPp1kYT3izLS5.png", "DC Entertainment", 9993, "US"
                ), ProductionCompaniesItem(
                    null, "Access Entertainment", 103376, "US"
                ), ProductionCompaniesItem(
                    "/42UPdZl6B2cFXgNUASR8hSt9mpS.png", "Dune Entertainment", 444, "US"
                ), ProductionCompaniesItem(
                    "/13F3Jf7EFAcREU0xzZqJnVnyGXu.png", "DC Films", 128064, "US"
                ), ProductionCompaniesItem(
                    "/2Tc1P3Ac8M479naPp1kYT3izLS5.png", "DC Comics", 429, "US"
                )
            ),
            "2021-03-18", 8.6, null,
            "", false, "https://www.hbomax.com/zacksnydersjusticeleague", "Released"
        )
    }
}