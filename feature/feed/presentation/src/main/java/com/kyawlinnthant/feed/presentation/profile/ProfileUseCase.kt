package com.kyawlinnthant.feed.presentation.profile

import com.kyawlinnthant.feed.domain.GetCurrentUser
import com.kyawlinnthant.feed.domain.Logout
import javax.inject.Inject

data class ProfileUseCase @Inject constructor(
    val logout: Logout,
    val currentUser: GetCurrentUser
)