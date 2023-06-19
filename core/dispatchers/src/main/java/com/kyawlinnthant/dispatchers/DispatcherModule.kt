package com.kyawlinnthant.dispatchers

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {
    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class DEFAULT

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class IO

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class MAIN

    @Retention(AnnotationRetention.RUNTIME)
    @Qualifier
    annotation class UNCONFINED

    @Provides
    @DEFAULT
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IO
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MAIN
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Provides
    @UNCONFINED
    fun provideUnconfinedDispatcher(): CoroutineDispatcher = Dispatchers.Unconfined
}