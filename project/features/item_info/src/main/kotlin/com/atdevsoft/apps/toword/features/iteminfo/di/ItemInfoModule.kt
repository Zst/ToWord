package com.atdevsoft.apps.toword.features.iteminfo.di

import com.atdevsoft.apps.toword.common.extensions.provideViewModel
import com.atdevsoft.apps.toword.core.di.scopes.FeatureScope
import com.atdevsoft.apps.toword.core.usecases.ToOtherDetailUseCase
import com.atdevsoft.apps.toword.core.usecases.ToReadDetailUseCase
import com.atdevsoft.apps.toword.core.usecases.ToWatchDetailUseCase
import com.atdevsoft.apps.toword.features.iteminfo.*
import dagger.Module
import dagger.Provides

@Module
class ItemInfoModule(private val fragment: ItemInfoFragment<*>) {

    @FeatureScope
    @Provides
    fun providesItemInfoViewModel(
        toWatchUseCase: ToWatchDetailUseCase,
        toReadUseCase: ToReadDetailUseCase,
        toOtherUseCase: ToOtherDetailUseCase
    ) = fragment.provideViewModel {
        ItemInfoViewModel(
            when (fragment) {
                is ToWatchItemInfoFragment -> toWatchUseCase
                is ToReadItemInfoFragment -> toReadUseCase
                is ToOtherItemInfoFragment -> toOtherUseCase
                else -> throw IllegalArgumentException("Unknown list fragment $fragment")
            },
            null //TODO: get from fragment arguments
        )
    }
}
