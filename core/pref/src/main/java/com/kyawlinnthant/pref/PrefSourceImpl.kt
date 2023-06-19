package com.kyawlinnthant.pref

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.kyawlinnthant.dispatchers.DispatcherModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class PrefSourceImpl @Inject constructor(
    private val store : DataStore<Preferences>,
    @DispatcherModule.IO private val io : CoroutineDispatcher
) : PrefSource{

    companion object {
        const val PREF_NAME = "ds.pref"
        val IS_AUTHENTICATED = booleanPreferencesKey("ds.pref.authenticated")
    }
    override suspend fun putAuthenticated(isAuthenticated: Boolean) {
        withContext(io) {
            store.edit {
                it[IS_AUTHENTICATED] = isAuthenticated
            }
        }
    }

    override suspend fun pullAuthenticated(): Flow<Boolean> {
        return store.data
            .catch { e ->
                if (e is IOException) emit(emptyPreferences()) else throw e
            }.map {
                it[IS_AUTHENTICATED] ?: false
            }.flowOn(io)
    }
}