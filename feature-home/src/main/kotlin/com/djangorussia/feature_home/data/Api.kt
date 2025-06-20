package com.djangorussia.feature_home.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Api(
    val characters: String,
    val locations: String,
    val episodes: String
)
