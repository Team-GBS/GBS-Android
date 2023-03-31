package com.gbs.gbs_android.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbs.data.local.LocalDataSource
import com.gbs.domain.usecase.GetTokenUseCase
import com.gbs.domain.usecase.SetTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GAuthViewModel @Inject constructor(
    private val setTokenUseCase: SetTokenUseCase,
    private val getTokenUseCase: GetTokenUseCase
): ViewModel() {
    fun setToken(token: String) {
        viewModelScope.launch {
            Log.d("settoken", token)
            setTokenUseCase(token)
        }
    }

    fun getToken() {
        viewModelScope.launch {
            delay(3000)
            val token = checkNotNull(getTokenUseCase().first())
            getTokenUseCase().collect {
                Log.d("token", it ?: "존재하지 않습니다.")
                Log.d("gettoken", token)
            }
        }
    }
}