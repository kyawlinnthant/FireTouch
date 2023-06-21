package com.kyawlinnthant.pref

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PrefModule {
    @Binds
    @Singleton
    fun bindPrefStore(pref: PrefSourceImpl): PrefSource
}