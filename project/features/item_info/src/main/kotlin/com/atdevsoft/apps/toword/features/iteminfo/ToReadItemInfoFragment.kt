package com.atdevsoft.apps.toword.features.iteminfo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.atdevsoft.apps.toword.features.iteminfo.databinding.FrItemInfoToReadBinding

class ToReadItemInfoFragment : ItemInfoFragment<FrItemInfoToReadBinding>() {
    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FrItemInfoToReadBinding =
        FrItemInfoToReadBinding.inflate(inflater, container, false)
}
