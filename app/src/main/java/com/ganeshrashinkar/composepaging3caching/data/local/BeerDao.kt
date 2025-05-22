package com.ganeshrashinkar.composepaging3caching.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.ganeshrashinkar.composepaging3caching.domain.Beer

@Dao
interface BeerDao {
    @Upsert
    fun upsertAll(beers: List<BeerEntity>)

    @Query("SELECT * FROM beerentity ")
    fun pagingSource():PagingSource<Int,BeerEntity>

    @Query("DELETE FROM beerentity")
     fun clearAll()
}