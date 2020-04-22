package com.atdevsoft.apps.toword.features.itemslist.di

import com.atdevsoft.apps.toword.common.extensions.provideViewModel
import com.atdevsoft.apps.toword.core.di.scopes.FeatureScope
import com.atdevsoft.apps.toword.core.usecases.ToOtherListUseCase
import com.atdevsoft.apps.toword.core.usecases.ToReadListUseCase
import com.atdevsoft.apps.toword.core.usecases.ToWatchListUseCase
import com.atdevsoft.apps.toword.features.itemslist.*
import dagger.Module
import dagger.Provides

@Module
class ItemsListModule(private val fragment: ItemsListFragment) {

    @FeatureScope
    @Provides
    fun providesItemsListViewModel(
        toWatchUseCase: ToWatchListUseCase,
        toReadUseCase: ToReadListUseCase,
        toOtherUseCase: ToOtherListUseCase
    ) = fragment.provideViewModel {
        ItemsListViewModel(
            when (fragment) {
                is ToWatchItemsListFragment -> toWatchUseCase
                is ToReadItemsListFragment -> toReadUseCase
                is ToOtherItemsListFragment -> toOtherUseCase
                else -> throw IllegalArgumentException("Unknown list fragment $fragment")
            }
        )
    }
}
