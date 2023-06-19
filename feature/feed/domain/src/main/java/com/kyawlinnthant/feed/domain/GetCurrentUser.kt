package com.kyawlinnthant.feed.domain

import com.kyawlinnthant.feed.data.FeedRepository
import com.kyawlinnthant.model.CurrentUser
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val repo: FeedRepository
) {

    suspend operator fun invoke(): Flow<CurrentUser> {
        return repo.getCurrentUser()
    }
}