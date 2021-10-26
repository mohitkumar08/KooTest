package com.kootest.data.service

import com.kootest.data.response.FeedResponse
import com.kootest.di.scope.AppMainScope
import retrofit2.http.GET
import retrofit2.http.Query

@AppMainScope
interface KooService {

    @GET("posts/")
    suspend fun getFeeds(@Query("page") pageNumber: Int): FeedResponse

}