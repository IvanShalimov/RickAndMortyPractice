package com.djangorussia.feature_home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.djangorussia.feature_home.domain.repository.HomeRepository
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(
    val repository: HomeRepository
): ViewModel() {
}