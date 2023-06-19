package com.kyawlinnthant.feed.presentation.profile

import com.kyawlinnthant.model.CurrentUser

data class ProfileViewModelState(
    val currentUser: CurrentUser = CurrentUser()
) {
    fun user() = currentUser
}
