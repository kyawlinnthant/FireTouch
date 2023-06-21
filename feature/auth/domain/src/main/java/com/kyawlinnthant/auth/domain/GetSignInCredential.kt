package com.kyawlinnthant.auth.domain

import android.content.Intent
import com.kyawlinnthant.auth.data.AuthRepository
import com.kyawlinnthant.auth.data.SignInCredentialResponse
import javax.inject.Inject

class GetSignInCredential @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(intent: Intent?): SignInCredentialResponse {
        return repo.getSignInCredential(intent)
    }
}