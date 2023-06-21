package com.kyawlinnthant.feed.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kyawlinnthant.common.DataResult
import com.kyawlinnthant.navigation.AppNavigator
import com.kyawlinnthant.navigation.Graph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val useCase: ProfileUseCase,
    private val navigator: AppNavigator
) : ViewModel() {

    private val vmState = MutableStateFlow(ProfileViewModelState())
    val currentUser = vmState
        .map(ProfileViewModelState::user)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = vmState.value.user()
        )

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            useCase.currentUser().collect {
                vmState.update { state ->
                    state.copy(
                        currentUser = it
                    )
                }
            }
        }
    }

    fun doLogout() {
        viewModelScope.launch {
            useCase.logout().also {
                when (it) {
                    is DataResult.Fail -> {
                    }

                    is DataResult.Success -> {
                        navigator.to(
                            route = Graph.Auth.route,
                            popupToRoute = Graph.Feature.route,
                            inclusive = true
                        )
                    }
                }
            }
        }
    }
}