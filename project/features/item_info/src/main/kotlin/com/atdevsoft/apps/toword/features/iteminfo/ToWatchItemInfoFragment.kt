package com.atdevsoft.apps.toword.features.iteminfo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.atdevsoft.apps.toword.features.iteminfo.databinding.FrItemInfoToWatchBinding

class ToWatchItemInfoFragment: ItemInfoFragment<FrItemInfoToWatchBinding>() {
    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FrItemInfoToWatchBinding =
        FrItemInfoToWatchBinding.inflate(inflater, container, false)
}

