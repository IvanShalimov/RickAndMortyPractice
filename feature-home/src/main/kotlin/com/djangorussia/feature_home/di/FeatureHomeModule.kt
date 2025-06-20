package com.djangorussia.feature_home.di

import com.djangorussia.feature_home.data.HomeApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class FeatureHomeModule {

    @FeatureScope
    @Provides
    fun provideHomeApi(retrofit: Retrofit): HomeApi {
        return retrofit.create(HomeApi::class.java)
    }
}