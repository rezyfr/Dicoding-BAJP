package com.rezyfr.dicoding.bajp.ui.utils

import com.rezyfr.dicoding.bajp.data.source.remote.response.*

object TvItemDummy {
    fun getTvListResponse(): TvListResponse {
        return TvListResponse(
            1, 500, listOf(
                TvResponse(
                    "2021-03-19",
                    "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                    "en",
                    listOf(
                        10765,
                        10759,
                        18
                    ), "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                    listOf(
                        "US"
                    ),
                    "/JB17sIsU53NuWVUecOwrCA0CUp.jpg",
                    "The Falcon and the Winter Soldier",
                    5502.543, 7.8, "The Falcon and the Winter Soldier", 88396, 3526
                ),
                TvResponse(
                    "2017-09-25",
                    "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                    "en",
                    listOf(
                        10765,
                        10759,
                        18
                    ), "/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg",
                    listOf(
                        "US"
                    ),
                    "/mZjZgY6ObiKtVuKVDrnS9VnuNlE.jpg",
                    "The Good Doctor",
                    1896.424, 8.6, "The Good Doctor", 71712, 7589
                ),
                TvResponse(
                    "2014-10-07",
                    "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                    "en",
                    listOf(
                        18,
                        10765
                    ), "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                    listOf(
                        "US"
                    ),
                    "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                    "The Flash",
                    1417.494, 7.7, "The Flash", 60735, 7310
                )
            ), 10000
        )
    }

    fun getTvDetail(): TvDetailResponse {
        return TvDetailResponse(
            "en",
            6,
            listOf(
                NetworksItem(
                    "/gJ8VX6JSu3ciXHuC2dDGAo2lvwM.png",
                    "Disney+", 2739, "US"
                )
            ),
            "Miniseries",
            "/JB17sIsU53NuWVUecOwrCA0CUp.jpg",
            listOf(
                GenresItem(
                    "Sci-Fi & Fantasy", 10765
                ),
                GenresItem(
                    "Action & Adventure", 10759
                ),
                GenresItem(
                    "Drama", 18
                ),
            ),
            5502.543,
            listOf(
                ProductionCountriesItem(
                    "US",
                    "United States of America"
                )
            ),
            88396,
            1,
            3565,
            "2021-03-19",
            "John Walker loses patience with Sam and Bucky as they learn more about Karli Morgenthau.",
            listOf(
                SeasonsItem(
                    "2021-03-19", "", 6, "Season 1", 1, 156676, "/fIT6Y6O3cUX1X8qY8pZgzEvxUDQ.jpg",
                )
            ),
            listOf("en"),
            listOf(
                CreatedByItem(
                    2,
                    "605508e2960cde00721fc5e8",
                    "Malcolm Spellman",
                    null,
                    1868712,
                )
            ),
            LastEpisodeToAir(
                "",
                "2021-04-09",
                "",
                4,
                7.2,
                "The Whole World Is Watching",
                1,
                2558741,
                "/4TEsU66PQT7G2cexbliJcpvTPbH.jpg",
                5
            ),
            "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
            listOf("us"),
            listOf(
                SpokenLanguagesItem(
                    "English",
                    "en",
                    "English"
                )
            ),
            listOf(
                ProductionCompaniesItem(
                    "/hUzeosd33nzE5MCNsZxCGEKTXaQ.png", "Marvel Studios", 420, "US"
                )
            ),
            "The Falcon and the Winter Soldier",
            7.8,
            "The Falcon and the Winter Soldier",
            "Honor the shield.",
            listOf(50),
            NextEpisodeToAir("", "2021-04-16", "", 5, 0.0, "", 1, 2558742, null, 0),
            true,
            "2021-04-09",
            "https://www.disneyplus.com/series/the-falcon-and-the-winter-soldier/4gglDBMx8icA",
            "Returning Series",
        )
    }
}