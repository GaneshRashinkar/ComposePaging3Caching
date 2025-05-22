package com.ganeshrashinkar.composepaging3caching.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.room.Room
import com.ganeshrashinkar.composepaging3caching.data.local.BeerDatabase
import com.ganeshrashinkar.composepaging3caching.data.local.BeerEntity
import com.ganeshrashinkar.composepaging3caching.data.remote.BeerAPI
import com.ganeshrashinkar.composepaging3caching.data.remote.BeerRemoteMediator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context:Context):BeerDatabase{
        return Room.databaseBuilder(context,BeerDatabase::class.java,"beers.db").build()
    }

    @Provides
    @Singleton
    fun provideBeerApi(): BeerAPI{
        return Retrofit.Builder()
            .baseUrl(BeerAPI.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beerDb:BeerDatabase, beerApi:BeerAPI):Pager<Int, BeerEntity>{
        return Pager(
            config = PagingConfig(20),
            remoteMediator = BeerRemoteMediator(
                beerDB = beerDb,
                beerApi = beerApi
            ),
            pagingSourceFactory = {
                beerDb.dao.pagingSource()
            }
        )
    }
}