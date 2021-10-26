package com.kootest.di.provider

import com.kootest.di.UserFeedsComponent

interface UserFeedComponentProvider {
    fun provideUserFeedsComponent(): UserFeedsComponent
}