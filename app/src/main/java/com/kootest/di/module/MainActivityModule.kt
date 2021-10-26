package com.kootest.di.module

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.kootest.di.scope.AppMainScope
import com.kootest.ui.adapter.FeedAdapter
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule {

    @AppMainScope
    @Provides
    fun provideKooService(context: Context): LinearLayoutManager {
        return LinearLayoutManager(context)
    }

    @AppMainScope
    @Provides
    fun provideFeedAdapter(): FeedAdapter = FeedAdapter()
}