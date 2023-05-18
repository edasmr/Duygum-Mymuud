package com.intersonik.duygum.di

import android.content.Context
import android.content.SharedPreferences
import com.intersonik.duygum.data.preferences.MyPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by
 * edasumer on 19.12.2022.
 */


@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences = context.getSharedPreferences( "currencyConvert", Context.MODE_PRIVATE )
    @Singleton
    @Provides fun provideSessionManager(preferences: SharedPreferences) = MyPreferences(preferences)
}

