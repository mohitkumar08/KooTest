package com.core

import android.content.Context
import android.os.Handler
import com.core.di.module.AppModule
import com.core.di.module.NetworkModule
import com.google.gson.Gson
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface BaseComponent {

    @Component.Builder
    interface Builder {
        fun appModule(appModule: AppModule): Builder
        fun build(): BaseComponent
    }

    fun retrofitApi(): Retrofit
    fun requireContext():Context
    fun requireHandler() :Handler
    fun provideGson(): Gson

}
