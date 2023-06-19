package com.kyawlinnthant.pref

import kotlinx.coroutines.flow.Flow

interface PrefSource {
    suspend fun putAuthenticated(isAuthenticated: Boolean)
    suspend fun pullAuthenticated(): Flow<Boolean>
}