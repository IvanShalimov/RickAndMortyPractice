package com.djangorussia.feature_home.di

import dagger.Subcomponent

@FeatureScope
@Subcomponent
interface FeatureHomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): FeatureHomeComponent
    }
}