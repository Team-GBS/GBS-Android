package com.gbs.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class DataSourceImpl(val context: Context): DataSource {

    companion object {
        val TOKEN = stringPreferencesKey("token")
    }

    override suspend fun setToken(token: String) {
        context.dataStore.edit { it[TOKEN] = token }
    }
}