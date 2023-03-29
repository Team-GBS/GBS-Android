package com.gbs.gbs_android.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbs.data.local.LocalDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GAuthViewModel @Inject constructor(
    private val dataSource: LocalDataSource
): ViewModel() {
    fun setToken(token: String) {
        viewModelScope.launch {
            Log.d("settoken", token)
            dataSource.setToken(token)
        }
    }

    fun getToken() {
        viewModelScope.launch {
            delay(3000)
            val token = checkNotNull(dataSource.getToken().first())
            dataSource.getToken().collect {
//                Log.d("token", it ?: "존재하지 않습니다.")
//                Log.d("gettoken", token)
            }
        }
    }
}