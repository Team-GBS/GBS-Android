package com.gbs.gbs_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbs.data.local.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GAuthViewModel @Inject constructor (
    private val dataSource: DataSource
): ViewModel() {
    fun setToken(token: String) {
        viewModelScope.launch {
            dataSource.setToken(token)
        }
    }
}