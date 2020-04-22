package com.atdevsoft.apps.toword.features.itemslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atdevsoft.apps.toword.core.model.ToDo
import com.atdevsoft.apps.toword.core.model.ToOther
import com.atdevsoft.apps.toword.core.model.ToRead
import com.atdevsoft.apps.toword.core.model.ToWatch
import com.atdevsoft.apps.toword.features.itemlist.databinding.LiItemBinding
import java.lang.UnsupportedOperationException


class ItemsListAdapter(private val viewModel: ItemsListViewModel) :
    ListAdapter<ToDo, ItemsListAdapter.ItemViewHolder>(diff) {
    class ItemViewHolder(val binding: LiItemBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        private val diff = object : DiffUtil.ItemCallback<ToDo>() {
            override fun areItemsTheSame(old: ToDo, new: ToDo): Boolean = old.id == new.id
            override fun areContentsTheSame(old: ToDo, new: ToDo): Boolean = old == new
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.root.setOnClickListener {
            viewModel.onItemClicked(item)
        }
        holder.binding.title.text = getToDoDisplayName(item)
    }

    private fun getToDoDisplayName(toDo: ToDo): CharSequence {
        return when (toDo) {
            is ToWatch -> "${toDo.title} (${toDo.year})"
            is ToRead -> "\"${toDo.book}\" by ${toDo.author})"
            is ToOther -> toDo.action
            else -> throw UnsupportedOperationException("Unknown ToDo type: ${toDo.javaClass.simpleName}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemViewHolder(LiItemBinding.inflate(LayoutInflater.from(parent.context)))
}