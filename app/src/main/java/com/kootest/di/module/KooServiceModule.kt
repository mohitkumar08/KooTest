package com.kootest.di.module

import com.kootest.data.service.KooService
import com.kootest.di.scope.AppMainScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
object KooServiceModule {

    @AppMainScope
    @Provides
    fun provideKooService(retrofit: Retrofit): KooService {
        return retrofit.create(KooService::class.java)
    }

}