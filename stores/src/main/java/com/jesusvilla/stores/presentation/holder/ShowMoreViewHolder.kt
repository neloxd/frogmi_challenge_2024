package com.jesusvilla.stores.presentation.holder

import com.jesusvilla.base.ui.BaseViewHolder
import com.jesusvilla.stores.databinding.ItemShowMoreBinding
import com.jesusvilla.stores.domain.model.AnyStore

class ShowMoreViewHolder(binding: ItemShowMoreBinding) :
    BaseViewHolder<AnyStore>(binding.root) {
    override fun bind(data: AnyStore, position: Int) {
        // anything
    }
}