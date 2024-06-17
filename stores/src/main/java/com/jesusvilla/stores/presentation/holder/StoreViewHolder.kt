package com.jesusvilla.stores.presentation.holder

import com.jesusvilla.base.ui.BaseViewHolder
import com.jesusvilla.stores.databinding.ItemStoreBinding
import com.jesusvilla.stores.domain.model.StoreUI

class StoreViewHolder(private val binding: ItemStoreBinding) :
    BaseViewHolder<StoreUI>(binding.root) {
    override fun bind(data: StoreUI, position: Int) {
        with(binding) {
            tvName.text = data.name
            tvCode.text = data.code
            tvAddress.text = data.fullAddress
        }
    }
}