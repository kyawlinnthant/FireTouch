package com.kyawlinnthant.auth.domain

import com.kyawlinnthant.auth.data.AuthRepository
import com.kyawlinnthant.auth.data.SignUpWithEmailResponse
import javax.inject.Inject

class SignupWithEmail @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(email: String, pwd: String): SignUpWithEmailResponse {
        return repo.signupWithEmail(email = email, pwd = pwd)
    }
}