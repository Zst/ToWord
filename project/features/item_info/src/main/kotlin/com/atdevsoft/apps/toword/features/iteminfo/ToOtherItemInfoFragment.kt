package com.atdevsoft.apps.toword.features.iteminfo

import android.view.LayoutInflater
import android.view.ViewGroup
import com.atdevsoft.apps.toword.features.iteminfo.databinding.FrItemInfoToOtherBinding

class ToOtherItemInfoFragment : ItemInfoFragment<FrItemInfoToOtherBinding>() {
    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FrItemInfoToOtherBinding =
        FrItemInfoToOtherBinding.inflate(inflater, container, false)
}
