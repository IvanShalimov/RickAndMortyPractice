package com.djangorussia.rickandmortypractice

import android.app.Application

class RickAndMortyApplication: Application() {

    val appComponent: RickAndMortyApplication by lazy {
        DaggerRickAndMortyApplicationComponent.factory().create(applicationContext)
    }
}