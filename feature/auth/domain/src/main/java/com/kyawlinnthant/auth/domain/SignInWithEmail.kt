package com.kyawlinnthant.auth.domain

import com.kyawlinnthant.auth.data.AuthRepository
import com.kyawlinnthant.auth.data.SignUpWithEmailResponse
import javax.inject.Inject

class SignInWithEmail @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(email: String, pwd: String): SignUpWithEmailResponse {
        return repo.signInWithEmail(email = email, pwd = pwd)
    }
}