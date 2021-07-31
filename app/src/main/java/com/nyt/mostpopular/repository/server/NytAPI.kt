package com.nyt.mostpopular.repository.server

import com.nyt.mostpopular.BuildConfig
import com.nyt.mostpopular.repository.models.MostViewedResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Muhammad Maqsood on 31/07/2021.
 */
interface NytAPI {

    @GET("mostviewed/{section}/{period}.json?api-key=${BuildConfig.API_KEY}")
    suspend fun getMostViewedArticles(
        @Path("section") section: String,
        @Path("period") period: String
    ): MostViewedResponse
}
