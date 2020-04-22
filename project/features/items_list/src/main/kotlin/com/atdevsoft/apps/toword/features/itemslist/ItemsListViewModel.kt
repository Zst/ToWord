package com.atdevsoft.apps.toword.features.itemslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.atdevsoft.apps.toword.core.model.ToDo
import com.atdevsoft.apps.toword.core.usecases.ToDoListUseCase

class ItemsListViewModel(
    private val itemsUseCase: ToDoListUseCase<*, *, *>
) : ViewModel() {
    val data = itemsUseCase.getAllItemsLiveData()

    private val _state = MutableLiveData<ItemsListViewState>()
    val state: LiveData<ItemsListViewState>
        get() = _state

    init {
        _state.postValue(ItemsListViewState.Loading)
        Transformations.map(data) {
            if (it.isEmpty()) {
                _state.postValue(ItemsListViewState.Empty)
            } else {
                _state.postValue(ItemsListViewState.Loaded)
            }
        }
    }

    fun onItemClicked(item: ToDo) {

    }

    fun onNewItemClicked() {

    }
}