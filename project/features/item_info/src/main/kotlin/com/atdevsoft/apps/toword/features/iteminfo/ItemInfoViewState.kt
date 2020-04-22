package com.atdevsoft.apps.toword.features.iteminfo

import com.atdevsoft.apps.toword.common.ui.BaseViewState

sealed class ItemInfoViewState : BaseViewState {

    object WaitingForLoad : ItemInfoViewState()
    object Loading : ItemInfoViewState()
    object Ready : ItemInfoViewState()

    fun isWaitingForLoad() = this is WaitingForLoad
    fun isLoading() = this is Loading
    fun isReady() = this is Ready
}
