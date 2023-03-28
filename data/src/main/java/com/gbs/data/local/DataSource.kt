package com.gbs.data.local

interface DataSource {
    suspend fun setToken(token: String)
}