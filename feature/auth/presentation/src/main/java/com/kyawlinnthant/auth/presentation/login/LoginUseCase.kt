package com.kyawlinnthant.auth.presentation.login

import com.kyawlinnthant.auth.domain.GetSignInCredential
import com.kyawlinnthant.auth.domain.GetSignInResult
import com.kyawlinnthant.auth.domain.SignInWithCredential
import com.kyawlinnthant.auth.domain.SignInWithEmail
import com.kyawlinnthant.auth.domain.SignupWithEmail
import javax.inject.Inject

data class LoginUseCase @Inject constructor(
    val signIn: SignInWithEmail,
    val signup: SignupWithEmail,
    val getResult: GetSignInResult,
    val getCredential: GetSignInCredential,
    val signInWithCredential: SignInWithCredential
)