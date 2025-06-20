package com.djangorussia.feature_home.domain.repository

import com.djangorussia.feature_home.data.HomeApi
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi
): HomeRepository