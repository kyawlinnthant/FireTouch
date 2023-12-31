package com.kyawlinnthant.firetouch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.auth.domain.GetAuthenticatedStatus
import com.kyawlinnthant.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAuthenticatedStatus: GetAuthenticatedStatus,
    private val appNavigator: AppNavigator,
) : ViewModel() {

    private val vmLoggedIn = MutableStateFlow<Boolean?>(null)
    val isLoggedIn get() = vmLoggedIn.asStateFlow()

    val instructor = appNavigator.instructor

    init {
        getLoggedIn()
    }

    private fun getLoggedIn() {
        viewModelScope.launch {
            vmLoggedIn.value = getAuthenticatedStatus()
        }
    }
}