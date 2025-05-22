package com.ganeshrashinkar.composepaging3caching.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface BeerAPI {
    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ):List<BeerDTO>
    companion object {
        const val BASE_URL="https://punkapi.online/v3/"
    }
}