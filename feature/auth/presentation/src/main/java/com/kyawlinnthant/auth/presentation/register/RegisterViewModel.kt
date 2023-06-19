package com.kyawlinnthant.auth.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.navigation.AppNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
//    private val repo: Repository,
    private val navigator: AppNavigator
) : ViewModel() {

    private val vmState = MutableStateFlow(RegisterViewModelState())
    val isLoading = vmState
        .map(RegisterViewModelState::loading)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = vmState.value.loading()
        )
    val tmpUri = vmState
        .map(RegisterViewModelState::tmpUri)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = vmState.value.tmpUri()
        )

    fun onAction(action: RegisterAction) {
        when (action) {
            is RegisterAction.UpdateTmpUri -> {
                vmState.update {
                    it.copy(
                        tmpUri = action.uri
                    )
                }
            }
        }
    }

    fun signup(email: String, pwd: String) {
        vmState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            /*  repo.signupWithEmail(email = email, pwd = pwd).also {
                  vmState.update { state ->
                      state.copy(isLoading = false)
                  }
                  when (it) {
                      is com.kyawlinnthant.common.DataResult.Fail -> {
                      }

                      is com.kyawlinnthant.common.DataResult.Success -> {
                          navigator.to(
                              route = Graph.Feature.route,
                              popupToRoute = Graph.Auth.route,
                              inclusive = true
                          )
                      }
                  }
              }*/
        }
    }
}
