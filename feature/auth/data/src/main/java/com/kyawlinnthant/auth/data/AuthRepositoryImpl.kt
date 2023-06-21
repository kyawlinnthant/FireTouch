package com.kyawlinnthant.auth.data

import android.content.Intent
import com.google.firebase.auth.AuthCredential
import com.kyawlinnthant.common.DataResult
import com.kyawlinnthant.firetouch.firebase.FirebaseSource
import com.kyawlinnthant.model.CurrentUser
import com.kyawlinnthant.pref.PrefSource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseSource: FirebaseSource,
    private val pref: PrefSource
) : AuthRepository {
    override suspend fun getAuthenticated(): Boolean {
        return false
    }

    override suspend fun signupWithEmail(email: String, pwd: String): SignUpWithEmailResponse {
        return when (val result = firebaseSource.signupWithEmail(email = email, pwd = pwd)) {
            is DataResult.Fail -> DataResult.Fail(result.message)
            is DataResult.Success -> {
                val isSuccessful = result.data != CurrentUser()
                // save in datastore
                pref.putAuthenticated(isSuccessful)
                DataResult.Success(isSuccessful)
            }
        }
    }

    override suspend fun signInWithEmail(email: String, pwd: String): SignInWithEmailResponse {
        return when (val result = firebaseSource.signInWithEmail(email = email, pwd = pwd)) {
            is DataResult.Fail -> DataResult.Fail(result.message)
            is DataResult.Success -> {
                val isSuccessful = result.data != CurrentUser()
                // save in datastore
                pref.putAuthenticated(isSuccessful)
                DataResult.Success(isSuccessful)
            }
        }
    }

    override suspend fun signInWithCredential(credential: AuthCredential): SignInWithCredentialResponse {
        return when (val result = firebaseSource.signInWithCredential(credential)) {
            is DataResult.Fail -> DataResult.Fail(result.message)
            is DataResult.Success -> {
                val isSuccessful = result.data != CurrentUser()
                // save in datastore
                pref.putAuthenticated(isSuccessful)
                DataResult.Success(isSuccessful)
            }
        }
    }

    override suspend fun getSignInResult(): SignInResultResponse {
        return firebaseSource.oneTapSignIn()
    }

    override suspend fun getSignInCredential(intent: Intent?): SignInCredentialResponse {
        return firebaseSource.getSignInCredential(intent)
    }
}