package com.gbs.gbs_android.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gbs.data.local.DataSource
import kotlinx.coroutines.launch

class GAuthViewModel(
    private val dataSource: DataSource
): ViewModel() {
    fun setToken(token: String) {
        viewModelScope.launch {
            dataSource.setToken(token)
        }
    }
}