package com.kyawlinnthant.pref

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefDatastoreModule {
    @Provides
    @Singleton
    fun providePrefStore(
        @ApplicationContext context: Context
    ) = PreferenceDataStoreFactory.create(
        produceFile = {
            context.preferencesDataStoreFile(PrefSourceImpl.PREF_NAME)
        }
    )
}