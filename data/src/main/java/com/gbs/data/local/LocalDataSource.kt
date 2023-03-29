package com.gbs.data.local

import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun setToken(token: String)
    fun getToken(): Flow<String?>
}