package com.kootest.data.repositiories

import com.genericresponse.NetworkResponse
import com.kootest.data.response.FeedResponse
import kotlinx.coroutines.flow.Flow

interface UserFeedRepository {
    fun getUserFeeds(page: Int): Flow<NetworkResponse<FeedResponse>>
}