package com.kyawlinnthant.auth.data

import android.content.Intent
import com.google.android.gms.auth.api.identity.BeginSignInResult
import com.google.android.gms.auth.api.identity.SignInCredential
import com.google.firebase.auth.AuthCredential
import com.kyawlinnthant.common.DataResult


typealias SignUpWithEmailResponse = DataResult<Boolean>
typealias SignInWithEmailResponse = DataResult<Boolean>
typealias SignInWithCredentialResponse = DataResult<Boolean>

interface AuthRepository {
    suspend fun getAuthenticated(): Boolean

    suspend fun signupWithEmail(email: String, pwd: String): SignUpWithEmailResponse
    suspend fun signInWithEmail(email: String, pwd: String): SignInWithEmailResponse
    suspend fun signInWithCredential(credential: AuthCredential): SignInWithCredentialResponse
    suspend fun getSignInResult(): DataResult<BeginSignInResult>
    suspend fun getSignInCredential(intent: Intent?): DataResult<SignInCredential>
}
