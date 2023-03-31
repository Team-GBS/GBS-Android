package com.gbs.data.repository

import com.gbs.data.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GAuthRepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource): GAuthRepository {
    override suspend fun setToken(token: String) {
        localDataSource.setToken(token)
    }

    override fun getToken(): Flow<String?> = localDataSource.getToken()

}