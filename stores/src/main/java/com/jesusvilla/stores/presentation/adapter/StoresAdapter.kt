package com.jesusvilla.stores.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jesusvilla.base.ui.BaseAdapter
import com.jesusvilla.base.ui.BaseViewHolder
import com.jesusvilla.stores.databinding.ItemShowMoreBinding
import com.jesusvilla.stores.databinding.ItemStoreBinding
import com.jesusvilla.stores.domain.model.AnyStore
import com.jesusvilla.stores.domain.model.BaseStore
import com.jesusvilla.stores.domain.model.StoreUI
import com.jesusvilla.stores.presentation.holder.ShowMoreViewHolder
import com.jesusvilla.stores.presentation.holder.StoreViewHolder

class StoresAdapter(
    context: Context,
    callbacks: List<Callback<BaseStore>> = listOf()
) : BaseAdapter<BaseStore, BaseViewHolder<*>>(
    mutableListOf(),
    context,
    callbacks
) {


    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newItesms: List<BaseStore>) {
        items.clear()
        items.addAll(newItesms)
        notifyDataSetChanged()
    }

    fun getItems(): List<BaseStore> {
        return items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            ViewType.Header.ordinal -> {
                val vh = ShowMoreViewHolder(ItemShowMoreBinding.inflate(inflater, parent, false))
                vh
            }

            ViewType.Content.ordinal -> {
                val vh = StoreViewHolder(ItemStoreBinding.inflate(inflater, parent, false))
                if (callbacks.isNotEmpty()) {
                    //vh.setCallback(callbacks[0])
                }
                vh
            }
            else -> throw IllegalArgumentException("Not a layout")
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is AnyStore -> ViewType.Header.ordinal
            is StoreUI -> ViewType.Content.ordinal
            else -> -1
        }
    }

    enum class ViewType {
        Header,
        Content,
        Footer
    }
}