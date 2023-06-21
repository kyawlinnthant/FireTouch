package com.kyawlinnthant.feed.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface FeedRepositoryModule {
    @Binds
    @Singleton
    fun bindsFeedRepo(repo: FeedRepositoryImpl): FeedRepository
}