package com.djangorussia.feature_home.data

import retrofit2.http.GET

interface HomeApi {

    @GET("api")
    fun getApi(): Api
}