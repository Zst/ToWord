package com.atdevsoft.apps.toword.features.iteminfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atdevsoft.apps.toword.core.model.ToDo
import com.atdevsoft.apps.toword.core.usecases.ToDoDetailUseCase
import kotlinx.coroutines.launch

class ItemInfoViewModel(
    private val itemUseCase: ToDoDetailUseCase<*, *, *>,
    private val itemId: Long?
) : ViewModel() {
    private val _data = MutableLiveData<ToDo>()
    val data: LiveData<ToDo>
        get() = _data

    private val _state = MutableLiveData<ItemInfoViewState>()
    val state: LiveData<ItemInfoViewState>
        get() = _state

    init {
        _state.postValue(ItemInfoViewState.WaitingForLoad)
    }

    fun loadItem(itemId: Long) {
        _state.postValue(ItemInfoViewState.Loading)
        viewModelScope.launch {
            _data.postValue(itemUseCase.getItem(itemId))
        }
    }

    fun onDismiss() {

    }

    fun onCloseToRead(book: String, author: String, comment: String) {

    }
}