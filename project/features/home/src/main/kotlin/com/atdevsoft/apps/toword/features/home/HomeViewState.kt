package com.atdevsoft.apps.toword.features.home

import com.atdevsoft.apps.toword.common.ui.BaseViewState

sealed class HomeViewState : BaseViewState {

    object DetailScreen : HomeViewState()
    object NavigationScreen : HomeViewState()

    fun isInDetailScreen() = this is DetailScreen
    fun isInNavigationScreen() = this is NavigationScreen
}
