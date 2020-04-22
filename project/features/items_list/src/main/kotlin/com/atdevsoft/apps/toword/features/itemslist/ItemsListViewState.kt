package com.atdevsoft.apps.toword.features.itemslist

import com.atdevsoft.apps.toword.common.ui.BaseViewState

sealed class ItemsListViewState : BaseViewState {

    object Loading : ItemsListViewState()
    object Loaded : ItemsListViewState()
    object Empty : ItemsListViewState()

    fun isLoading() = this is Loading
    fun isLoaded() = this is Loaded
    fun isEmpty() = this is Empty
}
