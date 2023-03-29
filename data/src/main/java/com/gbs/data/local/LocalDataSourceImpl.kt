package com.gbs.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class LocalDataSourceImpl @Inject constructor(
    @ApplicationContext val context: Context
) : LocalDataSource {

    companion object {
        val TOKEN = stringPreferencesKey("token")
    }

    override suspend fun setToken(token: String) {
        context.dataStore.edit { it[TOKEN] = token }
    }

    override fun getToken(): Flow<String?> = context.dataStore.data.catch { exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[TOKEN] ?: "저장되지않았습니다." }
}