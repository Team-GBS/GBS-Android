package com.gbs.di.module

import com.gbs.data.local.DataSource
import com.gbs.data.local.DataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsDataSource(
        dataSourceImpl: DataSourceImpl
    ): DataSource
}