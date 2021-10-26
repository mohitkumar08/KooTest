package com.kootest.di.module

import androidx.lifecycle.ViewModel
import com.kootest.ui.MainViewModel
import com.vmcore.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VMModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun userSessionViewModel(viewModel: MainViewModel): ViewModel

}
