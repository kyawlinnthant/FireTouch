package com.kyawlinnthant.auth.domain

import com.kyawlinnthant.auth.data.AuthRepository
import javax.inject.Inject

class GetAuthenticatedStatus @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(): Boolean {
        return repo.getAuthenticated()
    }
}