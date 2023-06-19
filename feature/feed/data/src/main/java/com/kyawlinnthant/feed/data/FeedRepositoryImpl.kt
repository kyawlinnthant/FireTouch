package com.kyawlinnthant.feed.data

import com.kyawlinnthant.firetouch.firebase.FirebaseSource
import com.kyawlinnthant.model.CurrentUser
import com.kyawlinnthant.pref.PrefSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val firebaseSource: FirebaseSource,
    private val pref : PrefSource
) : FeedRepository{
    override suspend fun signOut(): SignOutResponse {
        val result = firebaseSource.logout()
        result.data?.let {
            if (it) pref.putAuthenticated(false)
        }
        return result
    }

    override suspend fun getCurrentUser(): Flow<CurrentUser> {
        return firebaseSource.getCurrentUser()
    }
}