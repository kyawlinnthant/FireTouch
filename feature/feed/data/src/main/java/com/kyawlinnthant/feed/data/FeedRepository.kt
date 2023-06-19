package com.kyawlinnthant.feed.data

import com.kyawlinnthant.common.DataResult
import com.kyawlinnthant.model.CurrentUser
import kotlinx.coroutines.flow.Flow

typealias SignOutResponse = DataResult<Boolean>
interface FeedRepository {
    suspend fun signOut(): SignOutResponse
    suspend fun getCurrentUser(): Flow<CurrentUser>
}