package com.atdevsoft.apps.toword.features.itemslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.atdevsoft.apps.toword.common.ui.BaseFragment
import com.atdevsoft.apps.toword.core.model.ToDo
import com.atdevsoft.apps.toword.features.itemlist.databinding.FrItemsListBinding
import javax.inject.Inject

abstract class ItemsListFragment : BaseFragment<FrItemsListBinding, ItemsListViewModel>() {
    @Inject
    lateinit var adapter: ItemsListAdapter

    override fun onInitDependencyInjection() {

    }

    override fun onInitView() {
        super.onInitView()
        viewModel.data.observe(viewLifecycleOwner, Observer<List<ToDo>> { list ->
            adapter.submitList(list)
        })
        viewBinding?.itemsList?.adapter = adapter
        viewBinding?.newItem?.setOnClickListener {
            viewModel.onNewItemClicked()
        }
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): FrItemsListBinding {
        return FrItemsListBinding.inflate(inflater, container, false)
    }
}
