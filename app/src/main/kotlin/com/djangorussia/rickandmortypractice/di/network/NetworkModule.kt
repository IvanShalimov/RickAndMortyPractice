package com.djangorussia.rickandmortypractice.di.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class NetworkModule {

    @RetrofitMoshi
    @Provides
    fun provideRetrofitMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory()) // для корректной работы с data-классами
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(
        @RetrofitMoshi moshi: Moshi
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(" https://rickandmortyapi.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }
}