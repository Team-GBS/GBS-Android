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
            setTokenUseCase(token)
        }
    }

    fun getToken() {
        viewModelScope.launch {
            getTokenUseCase().collect { }
        }
    }
}