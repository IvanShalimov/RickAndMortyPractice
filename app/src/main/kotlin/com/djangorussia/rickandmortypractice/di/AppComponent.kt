package com.djangorussia.rickandmortypractice.di

import com.djangorussia.feature_home.di.FeatureHomeComponent
import com.djangorussia.rickandmortypractice.RickAndMortyApplication
import com.djangorussia.rickandmortypractice.di.network.NetworkModule
import dagger.Component
import retrofit2.Retrofit

@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun retrofit(): Retrofit
    fun inject(application: RickAndMortyApplication)

    fun featureHomeComponent(): FeatureHomeComponent.Factory
}