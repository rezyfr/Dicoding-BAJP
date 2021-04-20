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
            ASCENDING -> simpleQuery.append("ORDER BY itemTitle ASC")
            DESCENDING -> simpleQuery.append("ORDER BY itemTitle DESC")
            NEWEST -> simpleQuery.append("ORDER BY itemDate ASC")
            OLDEST -> simpleQuery.append("ORDER BY itemDate DESC")
            DEFAULT -> simpleQuery.append("")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getTvShowsSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM tv WHERE isFavorite = 1 ")
        when (filter) {
            ASCENDING -> simpleQuery.append("ORDER BY tvTitle ASC")
            DESCENDING -> simpleQuery.append("ORDER BY tvTitle DESC")
            NEWEST -> simpleQuery.append("ORDER BY tvDate ASC")
            OLDEST -> simpleQuery.append("ORDER BY tvDate DESC")
            DEFAULT -> simpleQuery.append("")
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}