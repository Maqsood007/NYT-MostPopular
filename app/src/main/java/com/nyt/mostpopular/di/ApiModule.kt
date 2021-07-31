package com.nyt.mostpopular.di

import com.nyt.mostpopular.repository.server.NytAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    internal fun nytAppAPI(retrofit: Retrofit): NytAPI = retrofit.create(
        NytAPI::class.java
    )
}
