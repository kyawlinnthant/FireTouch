package com.kyawlinnthant.feed.domain

import com.kyawlinnthant.common.DataResult
import com.kyawlinnthant.feed.data.FeedRepository
import javax.inject.Inject

class Logout @Inject constructor(
    private val repo : FeedRepository
) {
    suspend operator fun invoke(): DataResult<Boolean> {
        return repo.signOut()
    }
}