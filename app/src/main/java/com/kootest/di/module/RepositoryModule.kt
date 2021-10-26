package com.kootest.di.module

import com.kootest.data.repositiories.UserFeedRepository
import com.kootest.data.repositiories.UserFeedRepositoryImpl
import com.kootest.di.scope.AppMainScope
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
        @AppMainScope
        @Binds
        abstract fun provideUserFeedRepository(userFeedRepositoryImpl: UserFeedRepositoryImpl): UserFeedRepository
}