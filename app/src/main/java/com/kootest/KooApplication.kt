package com.kootest

import android.app.Application
import com.core.BaseComponent
import com.core.DaggerBaseComponent
import com.core.di.CoreComponentProvider
import com.core.di.module.AppModule
import com.kootest.di.DaggerUserFeedsComponent
import com.kootest.di.UserFeedsComponent
import com.kootest.di.provider.UserFeedComponentProvider

class KooApplication : Application(), CoreComponentProvider, UserFeedComponentProvider {

    private val baseComponent by lazy {
        DaggerBaseComponent.builder().appModule(AppModule(this)).build()
    }

    override fun provideBaseComponent(): BaseComponent {
        return baseComponent
    }

    override fun provideUserFeedsComponent(): UserFeedsComponent {
        return DaggerUserFeedsComponent.builder().dependBaseComponent(provideBaseComponent()).build()
    }

}