package com.kyawlinnthant.auth.domain

import com.kyawlinnthant.auth.data.AuthRepository
import com.kyawlinnthant.auth.data.SignInResultResponse
import javax.inject.Inject

class GetSignInResult @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(): SignInResultResponse {
        return repo.getSignInResult()
    }
}