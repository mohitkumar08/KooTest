package com.kootest.di

import androidx.recyclerview.widget.LinearLayoutManager
import com.core.BaseComponent
import com.kootest.di.module.MainActivityModule
import com.kootest.di.module.KooServiceModule
import com.kootest.di.module.RepositoryModule
import com.kootest.data.repositiories.UserFeedRepository
import com.kootest.di.module.VMModule
import com.kootest.di.scope.AppMainScope
import com.kootest.ui.MainActivity
import com.kootest.ui.adapter.FeedAdapter
import com.vmcore.VMFactoryModule
import dagger.Component

@AppMainScope
@Component(
    modules = [VMFactoryModule::class,
        VMModule::class,
        MainActivityModule::class,
        KooServiceModule::class,
        RepositoryModule::class],
    dependencies = [BaseComponent::class]
)
interface UserFeedsComponent {

    @Component.Builder
    interface Builder {
        fun dependBaseComponent(baseComponent: BaseComponent): Builder
        fun build(): UserFeedsComponent
    }

    fun inject(mainActivity: MainActivity)

    fun getUserFeedRepository(): UserFeedRepository

    fun getFeedAdapter(): FeedAdapter

    fun getLinearLayoutManager(): LinearLayoutManager


}