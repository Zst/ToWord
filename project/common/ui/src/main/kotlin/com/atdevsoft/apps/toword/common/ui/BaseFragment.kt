package com.atdevsoft.apps.toword.common.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

abstract class BaseFragment<V: ViewBinding, M : ViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: M

    protected var viewBinding: V? = null

    abstract fun onInitDependencyInjection()
    abstract fun inflateView(inflater: LayoutInflater, container: ViewGroup?): V

    open fun onInitView() {}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = inflateView(inflater, container)
        onInitView()
        return viewBinding?.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onInitDependencyInjection()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }
}
