package com.rezyfr.dicoding.bajp.ui.utils

import com.rezyfr.dicoding.bajp.data.source.local.entity.TvEntity

object TvItemDummy {
    fun getTvListResponse(): ArrayList<TvEntity> {
        return arrayListOf(
            TvEntity(
                88396, "The Falcon and the Winter Soldier",
                "Following the events of “Avengers: Endgame”, the Falcon, Sam Wilson and the Winter Soldier, Bucky Barnes team up in a global adventure that tests their abilities, and their patience.",
                "/6kbAMLteGO8yyewYau6bJ683sw7.jpg",
                "2021-03-19",

                ),
            TvEntity(
                71712,
                "The Good Doctor",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "en",
                "2017-09-25"
            ),
            TvEntity(
                60735,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "en",
                "2014-10-07",
            )
        )

    }

    fun getTvDetail(): TvEntity {
        return TvEntity(
            88396,
            "The Falcon and the Winter Soldier",
            "John Walker loses patience with Sam and Bucky as they learn more about Karli Morgenthau.",
            "/JB17sIsU53NuWVUecOwrCA0CUp.jpg", "2021-03-19"
        )
    }
}