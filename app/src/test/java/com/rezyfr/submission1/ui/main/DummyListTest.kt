package com.rezyfr.submission1.ui.main

import com.rezyfr.submission1.R
import com.rezyfr.submission1.data.ItemEntity

object DummyListTest {
    fun returnDummyData(): List<ItemEntity> {
        val movies = arrayListOf<ItemEntity>()
        movies.add(
            ItemEntity(
                1,
                "A Star is Born",
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally\'s career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.poster_a_start_is_born,
                "October 5, 2018"
            )
        )
        movies.add(
            ItemEntity(
                2,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power -hungry King Orm.With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world.Standing in his way is Arthur Curry, Orm\'s half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman,
                "December 21, 2018",
            )
        )
        movies.add(
            ItemEntity(
                3,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality . Everything the Avengers have fought for has led up to this moment -the fate of Earth and existence itself has never been more uncertain .",
                R.drawable.poster_infinity_war,
                "April 23, 2018",
            )
        )
        movies.add(
            ItemEntity(
                4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock \'n\' roll band Queen in 1970. Hit songs become instant classics.When Mercury \'s increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess .",
                R.drawable.poster_bohemian,
                "October 30, 2018",
            )
        )
        movies.add(
            ItemEntity(
                5,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family\'s past, Adonis Creed is up against the challenge of his life.",
                R.drawable.poster_creed,
                "November 14, 2018",
            )
        )
        movies.add(
            ItemEntity(
                6,
                "How To Train Your Dragon 3",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away.When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train,
                "February 22, 2019",
            )
        )
        movies.add(
            ItemEntity(
                7,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.poster_glass,
                "January 18, 2019",
            )
        )
        movies.add(
            ItemEntity(
                8,
                "Mortal Engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                R.drawable.poster_mortal_engines,
                "December 14, 2018",
            )
        )
        movies.add(
            ItemEntity(
                9,
                "Robin Hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                R.drawable.poster_robin_hood,
                "November 21, 2018",
            )
        )
        movies.add(
            ItemEntity(
                10,
                "Spiderman Into The Spider-verse",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                R.drawable.poster_spiderman,
                "December 1, 2018"
            )
        )

        return movies
    }
}