package com.rezyfr.dicoding.bajp.data.source.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtils {

    const val DEFAULT = "default"
    const val ASCENDING = "asc"
    const val DESCENDING = "desc"
    const val NEWEST = "newest"
    const val OLDEST = "oldest"

    fun getMoviesSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM movie WHERE isFavorite = 1 ")
        when (filter) {
            ASCENDING -> simpleQuery.append("ORDER BY title ASC")
            DESCENDING -> simpleQuery.append("ORDER BY title DESC")
            NEWEST -> simpleQuery.append("ORDER BY releaseDate DESC")
            OLDEST -> simpleQuery.append("ORDER BY releaseDate ASC")
            DEFAULT -> simpleQuery.append("")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getTvShowsSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM tv WHERE isFavorite = 1 ")
        when (filter) {
            ASCENDING -> simpleQuery.append("ORDER BY name ASC")
            DESCENDING -> simpleQuery.append("ORDER BY name DESC")
            NEWEST -> simpleQuery.append("ORDER BY firstAirDate DESC")
            OLDEST -> simpleQuery.append("ORDER BY firstAirDate ASC")
            DEFAULT -> simpleQuery.append("")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}