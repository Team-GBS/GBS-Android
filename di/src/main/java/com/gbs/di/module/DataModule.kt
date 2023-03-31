package com.gbs.di.module

import android.content.Context
import com.gbs.data.local.LocalDataSource
import com.gbs.data.local.LocalDataSourceImpl
import com.gbs.data.repository.GAuthRepository
import com.gbs.data.repository.GAuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.prefs.Preferences

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsDataSource(
        localDataSourceImpl: LocalDataSourceImpl
    ): LocalDataSource

    @Binds
    fun bindsGAuthRepository(
        gAuthRepositoryImpl: GAuthRepositoryImpl
    ): GAuthRepository
}