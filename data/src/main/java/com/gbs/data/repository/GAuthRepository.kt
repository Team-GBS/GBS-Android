package com.gbs.data.repository

import kotlinx.coroutines.flow.Flow

interface GAuthRepository {
    suspend fun setToken(token: String)
    fun getToken(): Flow<String?>
}