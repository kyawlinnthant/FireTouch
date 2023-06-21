package com.kyawlinnthant.auth.domain

import com.google.firebase.auth.AuthCredential
import com.kyawlinnthant.auth.data.AuthRepository
import com.kyawlinnthant.auth.data.SignInWithCredentialResponse
import javax.inject.Inject

class SignInWithCredential @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(credential: AuthCredential): SignInWithCredentialResponse {
        return repo.signInWithCredential(credential)
    }
}