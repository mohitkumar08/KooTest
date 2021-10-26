package com.kootest.data.repositiories

import com.genericresponse.NetworkResponse
import com.kootest.data.response.FeedResponse
import com.kootest.di.scope.AppMainScope
import com.kootest.data.service.KooService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@AppMainScope
class UserFeedRepositoryImpl @Inject constructor() : UserFeedRepository {

    @Inject
    lateinit var kooService: KooService

    override fun getUserFeeds(page: Int): Flow<NetworkResponse<FeedResponse>> = flow {
        try {
            emit(NetworkResponse.Init("InitApi"))
            val resp = kooService.getFeeds(page)
            emit(NetworkResponse.Success(resp))
        } catch (ex: Throwable) {
            ex.printStackTrace()
            emit(NetworkResponse.UnknownError(ex))
        }
    }
}